package common.entity;

import common.application.ValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class QuantityTest {

	@DisplayName("생성자에 음수를 사용할 경우 예외 발생.")
	@ParameterizedTest
	@ValueSource(longs = {-1, -1000})
	void constructor_Exception(long value) {
		assertThatThrownBy(() -> new Quantity(value))
				.isInstanceOf(ValidationException.class)
				.hasMessageMatching(Quantity.MSG_QUANTITY_MUST_EQUAL_OR_GREATER_THAN_ZERO);
	}

	@DisplayName("정상적인 생성자 사용.")
	@ParameterizedTest
	@ValueSource(longs = {1, 1000})
	void constructor(long value) {
		new Quantity(value);
	}
}