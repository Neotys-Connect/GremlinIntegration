package com.neotys.gremlin.actions.generator;

import java.util.List;

/**
 * @author lcharlois
 * @since 31/10/2020.
 */
class GremlinCommand {
	private final String name;
	private final String docUrl;
	private final String type;
	private final String command;
	private final String info;


	private final List<GremlinCommandArg> args;

	private GremlinCommand(final String name, final String docUrl, final String type, final String command, final String info, final List<GremlinCommandArg> args) {
		this.name = name;
		this.docUrl = docUrl;
		this.type = type;
		this.command = command;
		this.info = info;
		this.args = args;
	}

	static GremlinCommand createGremlinCommand(final String name, final String docUrl, final String type, final String command, final String info, final List<GremlinCommandArg> args) {
		return new GremlinCommand(name, docUrl, type, command, info, args);
	}

	public String getName() {
		return name;
	}


	@Override
	public String toString() {
		return "GremlinCommand{" +
				"name='" + name + '\'' +
				", docUrl='" + docUrl + '\'' +
				", type='" + type + '\'' +
				", command='" + command + '\'' +
				", info='" + info + '\'' +
				", args=" + args +
				'}';
	}

	public List<GremlinCommandArg> getArgs() {
		return args;
	}

	public String getDocUrl() {
		return docUrl;
	}

	public String getType() {
		return type;
	}

	public String getCommand() {
		return command;
	}

	public String getInfo() {
		return info;
	}

}
