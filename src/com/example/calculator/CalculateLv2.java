package com.example.calculator;

import java.util.ArrayList;

public class CalculateLv2 {
    // 변수 선언
    private ArrayList<Integer> calculationResults = new ArrayList<Integer>();

    //기능
    public int calculate(int num1, int num2, char operator) throws ArithmeticException, IllegalArgumentException {
        // 변수 선언
        int result = 0;

        // 연산
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException();
        }
        // 결과 저장
        this.calculationResults.add(result);
        // 결과 반환
        return result;
    }
    // 기록된 첫 번째 결과값 삭제
    public void removeResult() throws IndexOutOfBoundsException {
        calculationResults.remove(0);
    }
    // Getter
    public ArrayList<Integer> getCollection() {
        return this.calculationResults;
    }
    // Setter
    public void setCollection(ArrayList<Integer> calculationResults) {
        this.calculationResults = calculationResults;
    }
}
