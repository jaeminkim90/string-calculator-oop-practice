
# 객체지향 프로그래밍을 적용하여 문자열 계산기 만들기

---

## 기능 요구사항
- 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
- 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
- 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
- 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.


## 도메인 모델
- 연산자(Operator)
  - [X] 연산자 기호를 통해 연산자를 찾을 수  있다.
  - [X] 두 정수가 주어지면 두 정수를 연산자로 계산할 수 있다.
  

- 방정식(Equation)
  - 여러개의 정수와 여러개의 연산으로 구성된다
  - [X] 방정식의 연산 결과를 반환한다


- 방정식 팩토리(EquationFactory)
  - [X] 문자열을 방정식으로 변환한다


- 문자열 계싼기(StringCalculator)
  - [] 문자열 방정식의 연산 결과를 반환한다.


