package calculator;

public class StringCalculator {

    private final EquationFactory equationFactory;

    // 방정식 공장을 의존 관계로 주입받는다. 다른 방정식 공장을 주입받을 수 있기 때문에 확장성이 생긴다
    public StringCalculator(EquationFactory equationFactory) {
        this.equationFactory = equationFactory;
    }

    // 계산기 발사대 : 양식에 맞는 문자열 수식을 넣으면 계산 결과를 반환한다
    public int calculate(String input) {
        Equation equation = equationFactory.create(input); // 방정식 공장에서 방정식 객체를 만든다.
        return equation.calculate(); // 방정식 객체의 계산 결과를 반환한다.
    }
}
