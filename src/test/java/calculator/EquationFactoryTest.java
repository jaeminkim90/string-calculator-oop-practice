package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("EquationFactory 클래스")
public class EquationFactoryTest {

    @Nested
    @DisplayName("create 메소드는")
    class Describe_constructor {

        private Equation subject(String equation) {
            return new EquationFactory().create(equation);
        }

        @Nested
        @DisplayName("규격에 맞는 방정식 문자열이 주어진다면")
        class Context_right_input {
            @Test
            @DisplayName("방정식을 반환한다")
            void it_returns_a_equation() {
                assertNotNull(subject("1 + 2 / 3 + 5"));
            }
        }

        @Nested
        @DisplayName("규격에 맞지 않는 방정식 문자열이 주어진다면")
        class Context_wrong_input {
            @Test
            @DisplayName("예외를 던진다")
            void it_throws_exception() {
                assertThrows(IllegalArgumentException.class, () -> {
                    subject(" 1 ! 2 - 3");
                });
            }
        }
    }
}
