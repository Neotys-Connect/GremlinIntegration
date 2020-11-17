package com.neotys.gremlin.actions.generator;

import javax.annotation.Nullable;
import java.util.Optional;

/**
 * @author lcharlois
 * @since 01/11/2020.
 */
class GremlinArgValidator<T> {
	private final Class<T> type;
	@Nullable
	private final T min;
	@Nullable
	private final T max;

	GremlinArgValidator(final Class<T> type, final T min, final T max) {
		this.type = type;
		this.min = min;
		this.max = max;
	}

	public Optional<T> getMin() {
		return Optional.ofNullable(min);
	}

	public Optional<T> getMax() {
		return Optional.ofNullable(max);
	}

	public Class<T> getType() {
		return type;
	}
}
