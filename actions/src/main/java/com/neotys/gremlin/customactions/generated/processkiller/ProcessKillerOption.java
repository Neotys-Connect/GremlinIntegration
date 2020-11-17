package com.neotys.gremlin.customactions.generated.processkiller;

import static com.neotys.action.argument.DefaultArgumentValidator.ALWAYS_VALID;
import static com.neotys.action.argument.Option.AppearsByDefault.*;
import static com.neotys.action.argument.Option.OptionalRequired.*;
import static com.neotys.extensions.action.ActionParameter.Type.TEXT;

import com.neotys.action.argument.ArgumentValidator;
import com.neotys.extensions.action.ActionParameter;
import com.neotys.gremlin.common.GremlinOption;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;

public enum ProcessKillerOption implements GremlinOption {
  LENGTH("Length", Optional, False, TEXT, "60", "The length of the attack (seconds)\n"
      + "Value must be of type: Integer", new ArgumentValidator() {
    @Override
    public String getErrorMessage() {
      return "Value should be a Integer\n"
              + "Value must be greater than or equal to 1";
    }

    @Override
    public boolean apply(final String value) {
      try {
        final Integer parsed = Integer.valueOf(value);
        if (parsed < 1) {
          return false;
        }
        return true;
      } catch (Exception e) {
        return false;
      }
    }
  },"-l"),

  INTERVAL("Interval", Optional, False, TEXT, "1", "The number of seconds to delay before kills\n"
      + "Value must be of type: Integer", ALWAYS_VALID,"-i"),

  PROCESS("Process", Required, True, TEXT, "", "The process name to match (allows regex) or the process ID\n"
      + "Value must be of type: String", ALWAYS_VALID,"-p"),

  GROUP("Group", Optional, False, TEXT, "", "The group name or ID to match against (name matches only)\n"
      + "Value must be of type: String", ALWAYS_VALID,"-g"),

  USER("User", Optional, False, TEXT, "", "The user name or ID to match against (name matches only)\n"
      + "Value must be of type: String", ALWAYS_VALID,"-u"),

  NEWEST("Newest", Optional, Hided, TEXT, "false", "If set the newest matching process will be killed (name matches only, cannot be used with -o)\n"
      + "Value must be of type: Boolean", ALWAYS_VALID,"-n"),

  OLDEST("Oldest", Optional, Hided, TEXT, "false", "If set the oldest matching process will be killed (name matches only, cannot be used with -n)\n"
      + "Value must be of type: Boolean", ALWAYS_VALID,"-o"),

  EXACT("Exact", Optional, Hided, TEXT, "false", "If set the match must be exact and not just a substring match (name matches only)\n"
      + "Value must be of type: Boolean", ALWAYS_VALID,"-e"),

  KILL_CHILDREN("Kill Children", Optional, Hided, TEXT, "false", "If set the processes children will also be killed\n"
      + "Value must be of type: Boolean", ALWAYS_VALID,"-c"),

  FULL_MATCH("Full Match", Optional, Hided, TEXT, "false", "If set the processes name match will occur against the full command line string that the process was launched with\n"
      + "(allows regex)\n"
      + "Value must be of type: Boolean", ALWAYS_VALID,"-f");

  private final String name;

  private final com.neotys.action.argument.Option.OptionalRequired optionalRequired;

  private final com.neotys.action.argument.Option.AppearsByDefault appearsByDefault;

  private final ActionParameter.Type type;

  private final String defaultValue;

  private final String description;

  private final ArgumentValidator argumentValidator;

  private final String shortname;

  ProcessKillerOption(final String name,
      final com.neotys.action.argument.Option.OptionalRequired optionalRequired,
      final com.neotys.action.argument.Option.AppearsByDefault appearsByDefault,
      final ActionParameter.Type type, final String defaultValue, final String description,
      final ArgumentValidator argumentValidator, final String shortname) {
    this.name = name;
    this.optionalRequired = optionalRequired;
    this.appearsByDefault = appearsByDefault;
    this.type = type;
    this.defaultValue = defaultValue;
    this.description = description;
    this.argumentValidator = argumentValidator;
    this.shortname = shortname;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public com.neotys.action.argument.Option.OptionalRequired getOptionalRequired() {
    return this.optionalRequired;
  }

  @Override
  public com.neotys.action.argument.Option.AppearsByDefault getAppearsByDefault() {
    return this.appearsByDefault;
  }

  @Override
  public ActionParameter.Type getType() {
    return this.type;
  }

  @Override
  public String getDefaultValue() {
    return this.defaultValue;
  }

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public ArgumentValidator getArgumentValidator() {
    return this.argumentValidator;
  }

  @Override
  public String getShortname() {
    return this.shortname;
  }
}
