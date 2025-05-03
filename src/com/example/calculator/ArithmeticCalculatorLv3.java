package com.example.calculator;

import java.util.ArrayList;

public class ArithmeticCalculatorLv3<T extends Number> {
    // 변수 선언
    private ArrayList<Double> calculationResults = new ArrayList<>();

    //기능
    public double calculate(Number num1, Number num2, OperatorTypeLv3 operator) throws ArithmeticException {
        // 변수 선언
        double operand1 = num1.doubleValue();
        double operand2 = num2.doubleValue();
        double result = 0;

        // 연산
        switch (operator) {
            case ADD:
                result = operand1 + operand2;
                break;
            case SUB:
                result = operand1 - operand2;
                break;
            case MUL:
                result = operand1 * operand2;
                break;
            case DIV:
                result = operand1 / operand2;
                break;
        }
        // 결과 저장
        this.calculationResults.add(result);
        // 결과 반환
        return result;
    }
    // 기록된 첫 번째 결과값 삭제
    public void removeResult() throws IndexOutOfBoundsException{
        calculationResults.remove(0);
    }

    // Getter
    public ArrayList<Double> getCollection() {
        return this.calculationResults;
    }
    // Setter
    public void setCollection(ArrayList<Double> calculationResults) {
        this.calculationResults = calculationResults;
    }

}
