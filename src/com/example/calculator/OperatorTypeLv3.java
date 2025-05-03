package com.example.calculator;

public enum OperatorTypeLv3 {
        ADD('+'),
        SUB('-'),
        MUL('*'),
        DIV('/');

        private char c;

        OperatorTypeLv3(char c) {
                this.c = c;
        }

        public static OperatorTypeLv3 fromChar(char operator) throws IllegalArgumentException{
                for (OperatorTypeLv3 op : values()) {
                        if (op.c == operator) {
                                return op;  // 해당 연산자 기호를 가진 Enum 반환
                        }
                }
                throw new IllegalArgumentException();
        }
}
