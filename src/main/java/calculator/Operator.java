package calculator;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operator {
    SUM("+", Integer::sum), // 람다식의 메서드 레퍼런스로, Integer.sum을 사용한다는 의미다
    SUBTRACTION("-", (a, b) -> a - b),
    MULTIPLICATION("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b);

    // Enum 타입에서 사용하는 필드 값
    private final String symbol;
    private final IntBinaryOperator calculation; // 두 개의 int 매개값을 받아 int 값을 리턴한다

    Operator(String symbol, IntBinaryOperator calculation) {
        this.symbol = symbol;
        this.calculation = calculation;
    }

    static Operator from(String symbol) {
        return Arrays.stream(Operator.values())// Operator의 모든 값을 순환한다.
                .filter(operator -> symbol.equals(operator.symbol))// 매개 변수 symbol과 enum 상수의 symboldl 이 동일하면 통과한다.
                .findFirst() // 첫번째 발견한 enum 상수를 반환한다
               .orElseThrow(IllegalArgumentException::new); // 일치하는 것이 없다면 예외를 던진다
    }

    // 계산을 처리하는 메서드
    public int calculate(int a, int b) {
        return calculation.applyAsInt(a, b);
    }
}
