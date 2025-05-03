package com.example.calculator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppLv2 {

    public static void main(String[] args) {
        // 변수 선언
        Scanner scanner = new Scanner(System.in);
        CalculateLv2 calculator = new CalculateLv2();
        int num1, num2;

        while(true) {
            System.out.println("1. 사칙연산");
            System.out.println("2. 계산 결과 기록 출력");
            System.out.println("3. 계산 결과 기록 전부 삭제");
            System.out.println("4. 기록되어 있는 첫번째 계산 결과 삭제");
            System.out.print("하고 싶은 연산을 선택해주세요: ");
            int select;
            try {
                select = scanner.nextInt();
                scanner.nextLine(); // 버퍼 제거
            } catch (InputMismatchException e) {
                System.out.println("유효하지 않은 번호입니다.");
                System.out.println(" ");
                scanner.nextLine();
                continue;
            }

            switch(select) {
                case 1: // 사칙연산
                    // 첫번째 피연산자 입력
                    while (true) {
                        try {
                            System.out.print("첫 번째 숫자(양의 정수, 0 포함)를 입력하세요: ");
                            num1 = scanner.nextInt();
                            if (num1 >= 0)
                                break;
                            else
                                System.out.println("0을 포함한 양의 정수만 입력이 가능합니다.");
                        } catch (InputMismatchException e) {
                            System.out.println("0을 포함한 양의 정수만 입력이 가능합니다.");
                            scanner.nextLine();
                        }
                    }
                    // 두번째 피연산자 입력
                    while (true) {
                        try {
                            System.out.print("두 번째 숫자(양의 정수, 0 포함)를 입력하세요: ");
                            num2 = scanner.nextInt();
                            if (num2 >= 0)
                                break;
                            else
                                System.out.println("0을 포함한 양의 정수만 입력이 가능합니다.");

                        } catch (InputMismatchException e) {
                            System.out.println("0을 포함한 양의 정수만 입력이 가능합니다.");
                            scanner.nextLine();
                        }
                    }
                    // 사칙연산 기호 입력
                    System.out.print("사칙연산 기호를 입력하세요: ");
                    char operator = scanner.next().charAt(0);
                    scanner.nextLine();

                    // 연산
                    try {
                        int result = calculator.calculate(num1, num2, operator);
                        System.out.println("결과: " + result);
                    } catch (ArithmeticException e) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("유효하지 않은 사칙연산 기호입니다.");
                    }
                    break;
                case 2: // 계산 결과 기록 출력
                    ArrayList<Integer> calculationResults1 = calculator.getCollection();
                    if(calculationResults1.isEmpty()) {
                        System.out.println("계산 결과 기록이 없습니다.");
                    } else {
                        System.out.print("계산 결과 기록: ");
                        System.out.println(calculationResults1);
                    }
                    break;
                case 3: // 모든 계산 기록 삭제
                    ArrayList<Integer> calculationResults2 = new ArrayList<Integer>();
                    calculator.setCollection(calculationResults2);
                    System.out.println("모든 계산 기록이 삭제되었습니다.");
                    break;
                case 4: // 첫 번째 계산 기록 삭제
                    try {
                        calculator.removeResult();
                        System.out.println("첫 번째 계산 기록이 삭제되었습니다.");
                    } catch(IndexOutOfBoundsException e) {
                        System.out.println("삭제할 기록이 없습니다.");
                    }
                    break;
                default:
                    System.out.println("유효하지 않은 번호입니다.");

                }

            System.out.println(" ");
            // 계속 진행할지 여부
            System.out.print("더 진행하시겠습니까? (exit 입력 시 종료): ");
            String continueChoice = scanner.nextLine();
            if(continueChoice.equals("exit"))
                break;
        }
    }
}

