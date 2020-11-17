package com.neotys.gremlin.actions.generator;

import com.google.common.collect.ImmutableList;
import com.neotys.action.argument.ArgumentValidator;
import com.neotys.action.argument.Arguments;
import com.neotys.action.argument.DefaultArgumentValidator;
import com.neotys.action.argument.Option;
import com.neotys.extensions.action.ActionParameter;
import com.neotys.extensions.action.engine.ActionEngine;
import com.neotys.extensions.action.engine.Context;
import com.neotys.extensions.action.engine.SampleResult;
import com.neotys.gremlin.common.GreminUtils;
import com.neotys.gremlin.common.GremlinAction;
import com.neotys.gremlin.common.GremlinActionEngine;
import com.neotys.gremlin.common.GremlinOption;
import com.squareup.javapoet.*;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.lang.model.element.Modifier;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.Spliterators.spliteratorUnknownSize;

/**
 * @author lcharlois
 * @since 30/10/2020.
 */
public class CodeGenerator {

	public static void main(String[] args) throws IOException, URISyntaxException {
		final Path path = Paths.get(CodeGenerator.class.getResource("gremlin.json").getPath());
		final String jsonString = String.join("", Files.readAllLines(path, Charset.defaultCharset()));
		final JSONArray jsonArray = new JSONArray(jsonString);

		final List<GremlinCommand> commands = StreamSupport.stream(spliteratorUnknownSize(jsonArray.iterator(), Spliterator.ORDERED), false)
				.map(o -> ((JSONObject) o))
				.map(CodeGenerator::toGremlinCommand)
				.collect(Collectors.toList());
		commands.stream().map(GremlinCommand::getName).forEach(System.out::println);
		commands.forEach(c -> buildCommandClasses(c, args[0]));
	}

	private static void buildCommandClasses(final GremlinCommand command, final String destination) {
		final String commandNameFormatted = command.getName().replaceAll(" ", "");
		final TypeSpec optionClass = buildOptionClass(command, commandNameFormatted);
		final TypeSpec engineClass = buildEngineClass(command, commandNameFormatted,optionClass);
		final TypeSpec actionClass = buildActionClass(command, commandNameFormatted, optionClass, engineClass);


		JavaFile optionFile = JavaFile.builder("com.neotys.gremlin.customactions.generated." + commandNameFormatted.toLowerCase(), optionClass)
				.addStaticImport(Option.OptionalRequired.class, "*")
				.addStaticImport(Option.AppearsByDefault.class, "*")
				.addStaticImport(ActionParameter.Type.class, "TEXT")
				.addStaticImport(DefaultArgumentValidator.class, "ALWAYS_VALID")
				.build();
		JavaFile actionFile = JavaFile.builder("com.neotys.gremlin.customactions.generated." + commandNameFormatted.toLowerCase(), actionClass)
				.build();
		JavaFile engineFile = JavaFile.builder("com.neotys.gremlin.customactions.generated." + commandNameFormatted.toLowerCase(), engineClass)
				.build();

		final File file = new File(destination);
		try {
			optionFile.writeTo(file);
			actionFile.writeTo(file);
			engineFile.writeTo(file);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	private static TypeSpec buildEngineClass(final GremlinCommand command, final String commandNameFormatted, TypeSpec optionClass) {

		MethodSpec getOptions = MethodSpec.methodBuilder("getOptions")
				.addModifiers(Modifier.PUBLIC)
				.returns(GremlinOption[].class)
				.addAnnotation(Override.class)
				.addStatement("return $N.values()", optionClass)
				.build();

		MethodSpec getCommand = MethodSpec.methodBuilder("getCommand")
				.addModifiers(Modifier.PUBLIC)
				.returns(String.class)
				.addAnnotation(Override.class)
				.addStatement("return $S", command.getCommand())
				.build();

		MethodSpec getCommandType = MethodSpec.methodBuilder("getCommandType")
				.addModifiers(Modifier.PUBLIC)
				.returns(String.class)
				.addAnnotation(Override.class)
				.addStatement("return $S", command.getName())
				.build();

		MethodSpec getInvalidParameterCode = MethodSpec.methodBuilder("getInvalidParameterCode")
				.addModifiers(Modifier.PUBLIC)
				.returns(String.class)
				.addAnnotation(Override.class)
				.addStatement("return $S", "NL"+"-"+commandNameFormatted.toUpperCase()+"-ACTION-01")
				.build();

		//getInvalidParameterCode
		final TypeSpec.Builder action = TypeSpec.classBuilder(commandNameFormatted + "Engine")
				.addModifiers(Modifier.PUBLIC)
				.addMethod(getOptions)
				.addMethod(getCommand)
				.addMethod(getCommandType)
				.addMethod(getInvalidParameterCode)
				.superclass(GremlinActionEngine.class);
		return action.build();
	}

	private static TypeSpec buildActionClass(final GremlinCommand command, final String commandNameFormatted, final TypeSpec optionClass, final TypeSpec engineClass) {
		MethodSpec getType = MethodSpec.methodBuilder("getType")
				.addModifiers(Modifier.PUBLIC)
				.returns(String.class)
				.addAnnotation(Override.class)
				.addStatement("return $S", commandNameFormatted)
				.build();
		MethodSpec getDisplayName = MethodSpec.methodBuilder("getDisplayName")
				.addModifiers(Modifier.PUBLIC)
				.returns(String.class)
				.addAnnotation(Override.class)
				.addStatement("return $S", commandNameFormatted)
				.build();
		MethodSpec getDisplayPath = MethodSpec.methodBuilder("getDisplayPath")
				.addModifiers(Modifier.PUBLIC)
				.returns(String.class)
				.addAnnotation(Override.class)
				.addStatement("return $S", "Chaos Engineering/Gremlin/Attack")
				.build();
		MethodSpec getIcon = MethodSpec.methodBuilder("getIcon")
				.addModifiers(Modifier.PUBLIC)
				.returns(Icon.class)
				.addAnnotation(Override.class)
				.addStatement("return $T.getGremlinIcon()", GreminUtils.class)
				.build();
		MethodSpec getMinimumNeoLoadVersion = MethodSpec.methodBuilder("getMinimumNeoLoadVersion")
				.addModifiers(Modifier.PUBLIC)
				.returns(ParameterizedTypeName.get(com.google.common.base.Optional.class, String.class))
				.addAnnotation(Override.class)
				.addStatement("return $T.of($S)", com.google.common.base.Optional.class, "7.5")
				.build();
		MethodSpec getMaximumNeoLoadVersion = MethodSpec.methodBuilder("getMaximumNeoLoadVersion")
				.addModifiers(Modifier.PUBLIC)
				.returns(ParameterizedTypeName.get(com.google.common.base.Optional.class, String.class))
				.addAnnotation(Override.class)
				.addStatement("return $T.absent()", com.google.common.base.Optional.class)
				.build();
		final String description = new StringBuilder()
				.append(command.getInfo())
				.append("\n")
				.append(command.getDocUrl())
				.append("\n\n")
				.toString();
		MethodSpec getDescription = MethodSpec.methodBuilder("getCustomArgsDescription")
				.addModifiers(Modifier.PUBLIC)
				.returns(String.class)
				.addAnnotation(Override.class)
				.addStatement("return $S + $T.getArgumentDescriptions($N.values())", description, Arguments.class, optionClass)
				.build();
		MethodSpec getCustomActionParameters = MethodSpec.methodBuilder("getCustomActionParameters")
				.addModifiers(Modifier.PUBLIC)
				.returns(ParameterizedTypeName.get(List.class, ActionParameter.class))
				.addAnnotation(Override.class)
				.addStatement("return $T.stream($N.values()).filter(o -> $T.True.equals(o.getAppearsByDefault())).map(o -> new $T(o.getName(), o.getDefaultValue(),o.getType())).collect($T.toList())",
						Arrays.class,
						optionClass,
						Option.AppearsByDefault.class,
						ActionParameter.class,
						Collectors.class)
				.build();
		final TypeName wildcard = WildcardTypeName.subtypeOf(ActionEngine.class);
		final TypeName cls = ClassName.get(Class.class);
		MethodSpec getEngineClass = MethodSpec.methodBuilder("getEngineClass")
				.addModifiers(Modifier.PUBLIC)
				.returns(ParameterizedTypeName.get(ClassName.bestGuess(cls.toString()), wildcard))
				.addAnnotation(Override.class)
				.addStatement("return $N.class", engineClass)
				.build();
		final TypeSpec.Builder action = TypeSpec.classBuilder(commandNameFormatted + "Action")
				.addModifiers(Modifier.PUBLIC)
				.addMethods(ImmutableList.of(getType, getDisplayName, getDisplayPath, getIcon, getMinimumNeoLoadVersion, getMaximumNeoLoadVersion, getDescription, getCustomActionParameters, getEngineClass))
				.superclass(GremlinAction.class);
		return action.build();

	}

	private static TypeSpec buildOptionClass(final GremlinCommand command, final String commandNameFormatted) {
		final FieldSpec name = FieldSpec.builder(String.class, "name")
				.addModifiers(Modifier.PRIVATE, Modifier.FINAL)
				.build();
		final FieldSpec optionalRequired = FieldSpec.builder(Option.OptionalRequired.class, "optionalRequired")
				.addModifiers(Modifier.PRIVATE, Modifier.FINAL)
				.build();
		final FieldSpec appearsByDefault = FieldSpec.builder(Option.AppearsByDefault.class, "appearsByDefault")
				.addModifiers(Modifier.PRIVATE, Modifier.FINAL)
				.build();
		final FieldSpec type = FieldSpec.builder(ActionParameter.Type.class, "type")
				.addModifiers(Modifier.PRIVATE, Modifier.FINAL)
				.build();
		final FieldSpec defaultValue = FieldSpec.builder(String.class, "defaultValue")
				.addModifiers(Modifier.PRIVATE, Modifier.FINAL)
				.build();
		final FieldSpec description = FieldSpec.builder(String.class, "description")
				.addModifiers(Modifier.PRIVATE, Modifier.FINAL)
				.build();
		final FieldSpec argumentValidator = FieldSpec.builder(ArgumentValidator.class, "argumentValidator")
				.addModifiers(Modifier.PRIVATE, Modifier.FINAL)
				.build();
		final FieldSpec shortname = FieldSpec.builder(String.class, "shortname")
				.addModifiers(Modifier.PRIVATE, Modifier.FINAL)
				.build();

		MethodSpec getName = MethodSpec.methodBuilder("getName")
				.addModifiers(Modifier.PUBLIC)
				.returns(String.class)
				.addAnnotation(Override.class)
				.addStatement("return this.$N", "name")
				.build();

		MethodSpec getOptionalRequired = MethodSpec.methodBuilder("getOptionalRequired")
				.addModifiers(Modifier.PUBLIC)
				.returns(Option.OptionalRequired.class)
				.addAnnotation(Override.class)
				.addStatement("return this.$N", "optionalRequired")
				.build();
		MethodSpec getAppearsByDefault = MethodSpec.methodBuilder("getAppearsByDefault")
				.addModifiers(Modifier.PUBLIC)
				.returns(Option.AppearsByDefault.class)
				.addAnnotation(Override.class)
				.addStatement("return this.$N", "appearsByDefault")
				.build();
		MethodSpec getType = MethodSpec.methodBuilder("getType")
				.addModifiers(Modifier.PUBLIC)
				.returns(ActionParameter.Type.class)
				.addAnnotation(Override.class)
				.addStatement("return this.$N", "type")
				.build();
		MethodSpec getDefaultValue = MethodSpec.methodBuilder("getDefaultValue")
				.addModifiers(Modifier.PUBLIC)
				.returns(String.class)
				.addAnnotation(Override.class)
				.addStatement("return this.$N", "defaultValue")
				.build();
		MethodSpec getDescription = MethodSpec.methodBuilder("getDescription")
				.addModifiers(Modifier.PUBLIC)
				.returns(String.class)
				.addAnnotation(Override.class)
				.addStatement("return this.$N", "description")
				.build();
		MethodSpec getArgumentValidator = MethodSpec.methodBuilder("getArgumentValidator")
				.addModifiers(Modifier.PUBLIC)
				.returns(ArgumentValidator.class)
				.addAnnotation(Override.class)
				.addStatement("return this.$N", "argumentValidator")
				.build();
		MethodSpec getShortname = MethodSpec.methodBuilder("getShortname")
				.addModifiers(Modifier.PUBLIC)
				.returns(String.class)
				.addAnnotation(Override.class)
				.addStatement("return this.$N", "shortname")
				.build();

		final MethodSpec constructor = MethodSpec.constructorBuilder()
				.addParameter(String.class, "name", Modifier.FINAL)
				.addParameter(Option.OptionalRequired.class, "optionalRequired", Modifier.FINAL)
				.addParameter(Option.AppearsByDefault.class, "appearsByDefault", Modifier.FINAL)
				.addParameter(ActionParameter.Type.class, "type", Modifier.FINAL)
				.addParameter(String.class, "defaultValue", Modifier.FINAL)
				.addParameter(String.class, "description", Modifier.FINAL)
				.addParameter(ArgumentValidator.class, "argumentValidator", Modifier.FINAL)
				.addParameter(String.class, "shortname", Modifier.FINAL)
				.addStatement("this.$N = $N", "name", "name")
				.addStatement("this.$N = $N", "optionalRequired", "optionalRequired")
				.addStatement("this.$N = $N", "appearsByDefault", "appearsByDefault")
				.addStatement("this.$N = $N", "type", "type")
				.addStatement("this.$N = $N", "defaultValue", "defaultValue")
				.addStatement("this.$N = $N", "description", "description")
				.addStatement("this.$N = $N", "argumentValidator", "argumentValidator")
				.addStatement("this.$N = $N", "shortname", "shortname")
				.build();


		final TypeSpec.Builder option = TypeSpec.enumBuilder(commandNameFormatted + "Option")
				.addModifiers(Modifier.PUBLIC)
				.addFields(ImmutableList.of(name, optionalRequired, appearsByDefault, type, defaultValue, description, argumentValidator,shortname))
				.addSuperinterface(GremlinOption.class)
				.addMethods(ImmutableList.of(getName, getOptionalRequired, getAppearsByDefault, getType, getDefaultValue, getDescription, getArgumentValidator,getShortname))
				.addMethod(constructor);

		command.getArgs()
				.forEach(arg -> {
					final Option.OptionalRequired isRequired = arg.getRequired() ? Option.OptionalRequired.Required : Option.OptionalRequired.Optional;
					final Option.AppearsByDefault appears = arg.getRequired() ? Option.AppearsByDefault.True : arg.getAdvanced() ? Option.AppearsByDefault.Hided : Option.AppearsByDefault.False;
					final StringBuilder argDescription = new StringBuilder();
					argDescription.append(arg.getInfo());
					arg.getSubInfo().map(s -> "\n" + s).ifPresent(argDescription::append);
					argDescription.append("\n").append("Value must be of type: ").append(arg.getType());
					option.addEnumConstant(arg.getName().toUpperCase().replaceAll(" ", "_").replaceAll("%", "PERCENT"), TypeSpec.anonymousClassBuilder("$S, $L, $L, $L, $S, $S, $L,$S", arg.getName(), isRequired, appears, ActionParameter.Type.TEXT, arg.getDefaultValue().orElse(""), argDescription.toString(), buildValidator(arg).orElse(DefaultArgumentValidator.ALWAYS_VALID),arg.getShortname())
							.build());
				});
		return option.build();
	}

	private static Optional<Object> buildValidator(final GremlinCommandArg arg) {
		return arg.getArgumentValidator()
				.map(CodeGenerator::createValidator);
	}

	@SuppressWarnings("rawtypes")
	private static TypeSpec createValidator(final GremlinArgValidator v) {
		final String errorMessage = buildErrorMessage(v);
		return TypeSpec.anonymousClassBuilder("")
				.addSuperinterface(ArgumentValidator.class)
				.addMethod(MethodSpec.methodBuilder("getErrorMessage")
						.addAnnotation(Override.class)
						.addModifiers(Modifier.PUBLIC)
						.returns(String.class)
						.addStatement("return $S", errorMessage)
						.build())
				.addMethod(createValidatorApplyMethod(v))
				.build();
	}

	@SuppressWarnings("rawtypes")
	private static MethodSpec createValidatorApplyMethod(final GremlinArgValidator v) {
		final MethodSpec.Builder builder = MethodSpec.methodBuilder("apply")
				.addAnnotation(Override.class)
				.addModifiers(Modifier.PUBLIC)
				.addParameter(String.class, "value", Modifier.FINAL)
				.returns(boolean.class)
				.beginControlFlow("try")
				.addStatement("final $T parsed = $T.valueOf($N)", v.getType(), v.getType(), "value");

		if (v.getMin().isPresent()) {
			final Object min = v.getMin().get();
			builder.beginControlFlow("if ($N < $L)", "parsed", min)
					.addStatement("return $L", Boolean.FALSE)
					.endControlFlow();

		}
		if (v.getMax().isPresent()) {
			final Object max = v.getMax().get();
			builder.beginControlFlow("if ($N > $L)", "parsed", max)
					.addStatement("return $L", Boolean.FALSE)
					.endControlFlow();
		}
		builder
				.addStatement("return $L", Boolean.TRUE)
				.nextControlFlow("catch ($T e)", Exception.class)
				.addStatement("return $L", Boolean.FALSE)
				.endControlFlow();
		return builder.build();
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	private static String buildErrorMessage(final GremlinArgValidator gremlinArgValidator) {
		final StringBuilder builder = new StringBuilder()
				.append("Value should be a ")
				.append(gremlinArgValidator.getType().getSimpleName())
				.append("\n");
		gremlinArgValidator.getMin().ifPresent(v -> builder.append("Value must be greater than or equal to ").append(v));
		gremlinArgValidator.getMax().ifPresent(v -> builder.append("Value must be lesser than or equal to ").append(v));
		return builder.toString();
	}

	private static GremlinCommand toGremlinCommand(final JSONObject jsonObject) {
		final String name = jsonObject.getString("name");
		final String docUrl = jsonObject.getString("doc");
		final String type = jsonObject.getString("type");
		final String command = jsonObject.getString("command");
		final String info = jsonObject.getString("info");
		final List<GremlinCommandArg> args = parseArgs(jsonObject);

		return GremlinCommand.createGremlinCommand(name, docUrl, type, command, info, args);
	}

	private static List<GremlinCommandArg> parseArgs(final JSONObject jsonObject) {
		final JSONArray argsArray = jsonObject.getJSONArray("args");
		return StreamSupport.stream(spliteratorUnknownSize(argsArray.iterator(), Spliterator.ORDERED), false)
				.map(o -> ((JSONObject) o))
				.map(CodeGenerator::toGremlinCommandArg)
				.collect(Collectors.toList());
	}

	@SuppressWarnings("rawtypes")
	private static GremlinCommandArg toGremlinCommandArg(final JSONObject jsonObject) {
		final JSONObject validator = jsonObject.optJSONObject("validator");
		final String type = jsonObject.getString("type");
		final GremlinArgValidator argValidator;
		if (validator != null) {
			if (type.equals("Integer")) {
				final Integer min = Optional.ofNullable(validator.optJSONObject("min"))
						.map(j -> j.optInt("value", Integer.MAX_VALUE))
						.flatMap(v -> v == Integer.MAX_VALUE ? Optional.empty() : Optional.of(v))
						.orElse(null);
				final Integer max = Optional.ofNullable(validator.optJSONObject("max"))
						.map(j -> j.optInt("value", Integer.MIN_VALUE))
						.flatMap(v -> v == Integer.MIN_VALUE ? Optional.empty() : Optional.of(v))
						.orElse(null);
				argValidator = new GremlinArgValidator<>(Integer.class, min, max);
			} else if (type.equals("Float")) {
				final Float min = Optional.ofNullable(validator.optJSONObject("min"))
						.map(j -> j.optFloat("value", Float.MAX_VALUE))
						.flatMap(v -> v == Float.MAX_VALUE ? Optional.empty() : Optional.of(v))
						.orElse(null);
				final Float max = Optional.ofNullable(validator.optJSONObject("max"))
						.map(j -> j.optFloat("value", Float.MIN_VALUE))
						.flatMap(v -> v == Float.MIN_VALUE ? Optional.empty() : Optional.of(v))
						.orElse(null);
				argValidator = new GremlinArgValidator<>(Float.class, min, max);
			} else {
				argValidator = null;
			}
		} else {
			argValidator = null;
		}
		return new GremlinCommandArgBuilder().name(jsonObject.getString("name"))
				.key(jsonObject.getString("key"))
				.required(jsonObject.optBoolean("required", false))
				.advanced(jsonObject.optBoolean("advanced", false))
				.multiple(jsonObject.optBoolean("multiple", false))
				.info(jsonObject.getString("info"))
				.subInfo(jsonObject.optString("subinfo", null))
				.type(type)
				.defaultValue(jsonObject.optString("default"))
				.shortname(jsonObject.optString("short"))
				.argumentValidator(argValidator)
				.createGremlinCommandArg();

	}

}
