package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Equation 클래스")
public class EquationTest {

    @Nested
    @DisplayName("생성자는")
    class Describe_constructor {

        private Equation subject(List<Integer> numbers, List<Operator> operators) {
            return new Equation(numbers, operators);
        }

        @Nested
        @DisplayName("만약 두개의 숫자와 하나의 연산자가 주어진다면")
        class Context_two_number_and_one_operator {
            @Test
            @DisplayName("방정식 객체을 반환한다")
            void it_returns_a_equation() {
                assertNotNull(subject(Arrays.asList(1, 2), Arrays.asList(Operator.SUM)));
            }
        }

        @Nested
        @DisplayName("만약 하나 이하의 숫자가 주어진다면")
        class Context_one_number {
            @Test
            @DisplayName("예외를 던진다")
            void it_throws_exception() {
                assertThrows(IllegalArgumentException.class, () -> {
                    subject(Collections.singletonList(1), Collections.singletonList(Operator.SUM));
                });
            }

        }

        @Nested
        @DisplayName("만약 연산자가 주어지지 않는다면")
        class Context_empty_operator {
            @Test
            @DisplayName("예외를 던진다")
            void it_throws_exception() {
                assertThrows(IllegalArgumentException.class, () -> {
                    subject(Arrays.asList(1, 2), Collections.emptyList());
                });
            }
        }

        @Nested
        @DisplayName("만약 잘못된 포맷이 주어진다면 (숫자와 연산자의 개수가 적절하지 않을 경우)")
        class Context_wrong_format {
            @Test
            @DisplayName("예외를 던진다")
            void it_throws_exception() {
                assertThrows(IllegalArgumentException.class, () -> {
                    subject(Arrays.asList(1, 2, 3), Collections.singletonList(Operator.SUM));
                });
            }
        }
    }

    @Nested
    @DisplayName("calculate 메소드는")
    class Describe_calculate {

        @Test
        @DisplayName("연산 결과를 반환한다")
        void it_returns_a_result() {
            Equation equation = new Equation(
                    Arrays.asList(1, 2, 3),
                    Arrays.asList(Operator.SUM, Operator.DIVISION)
            );
            assertThat(equation.calculate()).isEqualTo(1);
        }
    }
}
