package com.neotys.gremlin.actions.generator;

import javax.annotation.Nullable;
import java.util.Optional;

/**
 * @author lcharlois
 * @since 31/10/2020.
 */
class GremlinCommandArg {
	@Nullable
	private final String defaultValue;
	private final String name;
	private final String type;
	private final String key;
	private final Boolean required;
	private final String info;
	@Nullable
	private final String subInfo;
	private final Boolean multiple;
	private final Boolean advanced;
	private final String shortname;
	@Nullable
	private final GremlinArgValidator argumentValidator;

	GremlinCommandArg(final String defaultValue, final String name, final String type, final String key, final Boolean required, final String info, final String subInfo, final Boolean multiple, final Boolean advanced, final GremlinArgValidator argumentValidator,String shortname) {
		this.defaultValue = defaultValue;
		this.name = name;
		this.type = type;
		this.key = key;
		this.required = required;
		this.info = info;
		this.shortname=shortname;
		this.subInfo = subInfo;
		this.multiple = multiple;
		this.advanced = advanced;
		this.argumentValidator = argumentValidator;
	}

	public Optional<String> getDefaultValue() {
		return Optional.ofNullable(defaultValue);
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getKey() {
		return key;
	}

	public Boolean getRequired() {
		return required;
	}

	public String getInfo() {
		return info;
	}

	public Optional<String> getSubInfo() {
		return Optional.ofNullable(subInfo);
	}

	public Boolean getMultiple() {
		return multiple;
	}

	public String getShortname() {
		return shortname;
	}

	public Boolean getAdvanced() {
		return advanced;
	}

	@Override
	public String toString() {
		return "GremlinCommandArg{" +
				"defaultValue='" + defaultValue + '\'' +
				", name='" + name + '\'' +
				", type='" + type + '\'' +
				", key='" + key + '\'' +
				", required=" + required +
				", info='" + info + '\'' +
				", subInfo='" + subInfo + '\'' +
				", multiple=" + multiple +
				", advanced=" + advanced +
				", short=" +shortname+
				", argumentValidator=" + argumentValidator +
				'}';
	}

	public Optional<GremlinArgValidator> getArgumentValidator() {
		return Optional.ofNullable(argumentValidator);
	}
}
