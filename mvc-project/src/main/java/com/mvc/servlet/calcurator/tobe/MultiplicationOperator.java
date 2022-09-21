package com.mvc.servlet.calcurator.tobe;

import com.mvc.servlet.calcurator.domain.PositiveNumber;

public class MultiplicationOperator implements ArithmeticOperator{
    @Override
    public boolean supports(String operator) {
        return "*".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        return operand1.toInt() * operand2.toInt();
    }
}
