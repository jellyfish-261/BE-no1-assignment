package com.example.calculator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CalculateLv3 {
    public static void main(String[] args) {
        // 변수 선언
        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculatorLv3<Number> calculator = new ArithmeticCalculatorLv3<>();
        Number num1, num2;

        while(true) {
            System.out.println("1. 사칙연산");
            System.out.println("2. 계산 결과 기록 출력");
            System.out.println("3. 계산 결과 기록 전부 삭제");
            System.out.println("4. 기록되어 있는 첫번째 계산 결과 삭제");
            System.out.println("5. 특정 수보다 큰 계산 결과 출력");
            System.out.print("하고 싶은 연산을 선택해주세요: ");
            int select;
            try {
                select = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("유효하지 않은 번호입니다.");
                System.out.println(" ");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine(); // 버퍼 제거

            switch(select) {
                case 1: // 사칙연산
                    // 첫번째 피연산자 입력
                    while (true) {
                        try {
                            System.out.print("첫 번째 숫자를 입력하세요: ");
                            String input1 = scanner.nextLine();
                            if (input1.contains(".")) {
                                num1 = Double.parseDouble(input1);
                            }
                            else
                                num1 = Integer.parseInt(input1);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("정수 혹은 실수만 입력 가능합니다");
                        }
                    }
                    // 두번째 피연산자 입력
                    while (true) {
                        try {
                            System.out.print("두 번째 숫자를 입력하세요: ");
                            String input2 = scanner.nextLine();
                            if (input2.contains(".")) {
                                num2 = Double.parseDouble(input2);
                            }
                            else
                                num2 = Integer.parseInt(input2);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("정수 혹은 실수만 입력 가능합니다");
                        }
                    }
                    // 사칙연산 기호 입력
                    System.out.print("사칙연산 기호를 입력하세요: ");
                    char input = scanner.next().charAt(0);
                    scanner.nextLine();

                    try {
                        OperatorTypeLv3 operator = OperatorTypeLv3.fromChar(input);
                        double result = calculator.calculate(num1, num2, operator);
                        if(result == (int)result) {
                            System.out.println("결과: " + (int)result);
                        } else {
                            System.out.println("결과: " + result);
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("유효하지 않은 사칙연산 기호입니다.");
                    }  catch (ArithmeticException e) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    }
                    break;
                    case 2: // 계산 결과 기록 출력
                    ArrayList<Double> calculationResults1 = calculator.getCollection();
                    if(calculationResults1.isEmpty()) {
                        System.out.println("계산 결과 기록이 없습니다.");
                    } else {
                        System.out.print("계산 결과 기록: ");
                        System.out.println(calculationResults1);
                    }
                    break;
                case 3: // 모든 계산 기록 삭제
                    ArrayList<Double> calculationResults2 = new ArrayList<>();
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
                case 5: // 특정 수보다 큰 계산 결과 출력
                    System.out.print("숫자를 입력해주세요: ");
                    double input1 = scanner.nextDouble();
                    scanner.nextLine();
                    ArrayList<Double> calculationResults3 = new ArrayList<>();
                    calculationResults3 = calculator.getCollection();
                    List<Double> result = calculationResults3.stream().filter(num -> num > input1).collect(Collectors.toList());
                    if(result.isEmpty()) {
                        System.out.println("결과가 없습니다.");
                    } else {
                        System.out.println("결과 = " + result);
                    }
                    break;
                default:
                    System.out.println("유효하지 않은 번호입니다.");
            }

            // 계속 진행할지 여부
            System.out.print("더 진행하시겠습니까? (exit 입력 시 종료): ");
            // scanner.nextLine(); // 버퍼 제거
            String continueChoice = scanner.nextLine();
            if(continueChoice.equals("exit"))
                break;
            System.out.println(" ");
        }
    }
}
