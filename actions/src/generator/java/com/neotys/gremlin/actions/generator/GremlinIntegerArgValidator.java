package com.neotys.gremlin.actions.generator;

import javax.annotation.Nullable;
import java.util.Optional;

/**
 * @author lcharlois
 * @since 01/11/2020.
 */
class GremlinIntegerArgValidator {
	@Nullable
	private final Integer min;
	@Nullable
	private final Integer max;

	private GremlinIntegerArgValidator(final Integer min, final Integer max) {
		this.min = min;
		this.max = max;
	}

	public Optional<Integer> getMin() {
		return Optional.ofNullable(min);
	}

	public Optional<Integer> getMax() {
		return Optional.ofNullable(max);
	}
}
