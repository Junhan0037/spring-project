package com.mvc.oop.calculator.tobe;

import com.mvc.oop.calculator.domain.PositiveNumber;

public class AdditionOperator implements ArithmeticOperator {
    @Override
    public boolean supports(String operator) {
        return "+".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        return operand1.toInt() + operand2.toInt();
    }
}
