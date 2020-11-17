package com.neotys.gremlin.customactions.generated.timetravel;

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

public enum TimeTravelOption implements GremlinOption {
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

  NTP("NTP", Optional, False, TEXT, "false", "Block NTP network communication\n"
      + "Blackholes outbound udp traffic over port 123\n"
      + "Value must be of type: Boolean", ALWAYS_VALID,"-n"),

  OFFSET("Offset", Optional, False, TEXT, "86400", "The offset to the current time (seconds)\n"
      + "Can be positive or negative\n"
      + "Value must be of type: Integer", ALWAYS_VALID,"-o");

  private final String name;

  private final com.neotys.action.argument.Option.OptionalRequired optionalRequired;

  private final com.neotys.action.argument.Option.AppearsByDefault appearsByDefault;

  private final ActionParameter.Type type;

  private final String defaultValue;

  private final String description;

  private final ArgumentValidator argumentValidator;

  private final String shortname;

  TimeTravelOption(final String name,
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
