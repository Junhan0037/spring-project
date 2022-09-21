package com.mvc.oop.calculator;

import com.mvc.oop.calculator.domain.Calculator;
import com.mvc.oop.calculator.domain.PositiveNumber;
import com.mvc.oop.calculator.ui.ConsoleInputUI;
import com.mvc.oop.calculator.ui.ConsoleOutputUI;

public class CalculatorMain {
    public static void main(String[] args) {
        PositiveNumber operand1 = new PositiveNumber(ConsoleInputUI.enterOperand());
        String operator = ConsoleInputUI.enterOperator();
        PositiveNumber operand2 = new PositiveNumber(ConsoleInputUI.enterOperand());

        int result = Calculator.calculate(operand1, operator, operand2);

        ConsoleOutputUI.printResult(result);
    }
}
