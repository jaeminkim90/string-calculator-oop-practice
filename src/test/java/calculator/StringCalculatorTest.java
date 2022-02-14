package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("StringCalculator 테스트")
public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void prepareCalculator() {
        stringCalculator = new StringCalculator(new EquationFactory());
    }

    @Nested
    @DisplayName("calculate 메소드는")
    class Describe_calculate {

        @Nested
        @DisplayName("문자열 방정식이 주어진다면")
        class Context_with_input {

            @Test
            @DisplayName("연산 결과를 반환한다")
            void it_returns_a_result() {
                assertThat(stringCalculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
            }
        }

    }
}
