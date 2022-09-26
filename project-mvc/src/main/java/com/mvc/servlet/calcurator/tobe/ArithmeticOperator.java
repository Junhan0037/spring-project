package com.mvc.servlet.calcurator.tobe;

import com.mvc.servlet.calcurator.domain.PositiveNumber;

public interface ArithmeticOperator {
    boolean supports(String operator);
    int calculate(final PositiveNumber operand1, final PositiveNumber operand2);
}
