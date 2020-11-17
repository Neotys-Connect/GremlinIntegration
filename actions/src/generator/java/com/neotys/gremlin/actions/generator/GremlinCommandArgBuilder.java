package com.neotys.gremlin.actions.generator;

public class GremlinCommandArgBuilder {
	private String defaultValue = null;
	private String name;
	private String type;
	private String key;
	private Boolean required = false;
	private String info;
	private String subInfo = null;
	private Boolean multiple = false;
	private Boolean advanced = false;
	private GremlinArgValidator argumentValidator = null;
	private String shortname;

	public GremlinCommandArgBuilder defaultValue(final String defaultValue) {
		this.defaultValue = defaultValue;
		return this;
	}

	public GremlinCommandArgBuilder name(final String name) {
		this.name = name;
		return this;
	}

	public GremlinCommandArgBuilder type(final String type) {
		this.type = type;
		return this;
	}

	public GremlinCommandArgBuilder key(final String key) {
		this.key = key;
		return this;
	}

	public GremlinCommandArgBuilder required(final boolean required) {
		this.required = required;
		return this;
	}

	public GremlinCommandArgBuilder info(final String info) {
		this.info = info;
		return this;
	}

	public GremlinCommandArgBuilder subInfo(final String subInfo) {
		this.subInfo = subInfo;
		return this;
	}

	public GremlinCommandArgBuilder multiple(final boolean multiple) {
		this.multiple = multiple;
		return this;
	}

	public GremlinCommandArgBuilder advanced(final boolean advanced) {
		this.advanced = advanced;
		return this;
	}

	public GremlinCommandArgBuilder argumentValidator(final GremlinArgValidator argumentValidator) {
		this.argumentValidator = argumentValidator;
		return this;
	}

	public GremlinCommandArgBuilder shortname(final String shortname) {
		this.shortname = shortname;
		return this;
	}

	public GremlinCommandArg createGremlinCommandArg() {
		return new GremlinCommandArg(defaultValue, name, type, key, required, info, subInfo, multiple, advanced, argumentValidator,shortname);
	}
}