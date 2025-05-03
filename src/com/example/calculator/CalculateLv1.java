package com.example.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculateLv1 {
    public static void main(String[] args) {
        // 변수 선언
        Scanner scanner = new Scanner(System.in);
        int num1, num2;
        int result = 0;
        boolean valid;

        while(true) {
            // 첫번째 피연산자 입력
            while(true) {
                try {
                    System.out.print("첫 번째 숫자(양의 정수, 0 포함)를 입력하세요: ");
                    num1 = scanner.nextInt();
                    if(num1 >= 0)
                        break;
                    else
                        System.out.println("0을 포함한 양의 정수만 입력이 가능합니다.");
                } catch(InputMismatchException e) {
                    System.out.println("0을 포함한 양의 정수만 입력이 가능합니다.");
                    scanner.nextLine();
                }
            }
            // 두번째 피연산자 입력
            while(true) {
                try {
                    System.out.print("두 번째 숫자(양의 정수, 0 포함)를 입력하세요: ");
                    num2 = scanner.nextInt();
                    if(num2 >= 0)
                        break;
                    else
                        System.out.println("0을 포함한 양의 정수만 입력이 가능합니다.");

                } catch(InputMismatchException e) {
                    System.out.println("0을 포함한 양의 정수만 입력이 가능합니다.");
                    scanner.nextLine();
                }
            }
            // 사칙연산 기호 입력
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = scanner.next().charAt(0);
            scanner.nextLine();

            // 연산
            valid = true;
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
                    try {
                        result = num1 / num2;
                    }
                    catch (ArithmeticException e) {
                        valid = false;
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    }
                    break;
                default:
                    valid = false;
                    System.out.println("유효하지 않은 사칙연산 기호입니다.");
            }

            // 결과 출력
            if(valid) {
                System.out.println("결과: " + result);
            }

            // 계속 계산 진행할지 여부
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            // scanner.nextLine(); // 버퍼 제거
            String continueChoice = scanner.nextLine();
            if(continueChoice.equals("exit"))
                break;
        }
    }
}
