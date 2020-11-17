package com.neotys.gremlin.customactions.generated.memory;

import static com.neotys.action.argument.DefaultArgumentValidator.ALWAYS_VALID;
import static com.neotys.action.argument.Option.AppearsByDefault.*;
import static com.neotys.action.argument.Option.OptionalRequired.*;
import static com.neotys.extensions.action.ActionParameter.Type.TEXT;

import com.neotys.action.argument.ArgumentValidator;
import com.neotys.extensions.action.ActionParameter;
import com.neotys.gremlin.common.GremlinOption;
import java.lang.Exception;
import java.lang.Float;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;

public enum MemoryOption implements GremlinOption {
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

  MB("MB", Optional, False, TEXT, "", "The number of megabytes to allocate\n"
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
  },"-m"),

  GB("GB", Optional, False, TEXT, "0.5", "The number of gigabytes to allocate\n"
      + "Value must be of type: Float", new ArgumentValidator() {
    @Override
    public String getErrorMessage() {
      return "Value should be a Float\n"
              + "Value must be greater than or equal to 0.1";
    }

    @Override
    public boolean apply(final String value) {
      try {
        final Float parsed = Float.valueOf(value);
        if (parsed < 0.1) {
          return false;
        }
        return true;
      } catch (Exception e) {
        return false;
      }
    }
  },"-g"),

  PERCENT("%", Optional, False, TEXT, "", "The percent of total memory to allocate\n"
      + "Value must be of type: Integer", new ArgumentValidator() {
    @Override
    public String getErrorMessage() {
      return "Value should be a Integer\n"
              + "Value must be greater than or equal to 1Value must be lesser than or equal to 100";
    }

    @Override
    public boolean apply(final String value) {
      try {
        final Integer parsed = Integer.valueOf(value);
        if (parsed < 1) {
          return false;
        }
        if (parsed > 100) {
          return false;
        }
        return true;
      } catch (Exception e) {
        return false;
      }
    }
  },"-p");

  private final String name;

  private final com.neotys.action.argument.Option.OptionalRequired optionalRequired;

  private final com.neotys.action.argument.Option.AppearsByDefault appearsByDefault;

  private final ActionParameter.Type type;

  private final String defaultValue;

  private final String description;

  private final ArgumentValidator argumentValidator;

  private final String shortname;

  MemoryOption(final String name,
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
