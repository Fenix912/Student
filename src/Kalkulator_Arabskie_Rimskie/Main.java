package Kalkulator_Arabskie_Rimskie;

import java.util.Scanner;

public class Main {

    public static int numberOne, numberTwo;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InputUtil inputUtil = new InputUtil();
        Operation operationObj = new Operation();
        CheckInput checkInput = new CheckInput();

        System.out.println("Этот калькулятор, работает только с арабскими и римскими числами");
        System.out.println("Введите значение от 1 до 10 включительно, через пробел");
        System.out.println("Для выхода введите 'EXIT'.");
        System.out.println("Калькулятор умет работать с операцями (*, /, +, -)");

        while (true) {
            System.out.print("Ввод: ");
            String userInput = scanner.nextLine();
            String exitKey = userInput.toLowerCase();

            if (exitKey.equals("exit")) {
                System.out.println("Всего доброго");
                break;
            }

            inputUtil.stringToArray(userInput);
            char operation = inputUtil.operation;

            try {
                if (checkInput.isNumeric(inputUtil.getNumberOne()) || (checkInput.isNumeric(inputUtil.getNumberTwo()))) {
                    int numberOne = Integer.parseInt(inputUtil.getNumberOne());
                    int numberTwo = Integer.parseInt(inputUtil.getNumberTwo());

                    if (numberOne < 11 && numberOne > 0) {
                        if (numberTwo > 0 && numberTwo < 11) {
                            System.out.println(operationObj.result(numberOne, numberTwo, operation));
                        } else {
                            throw new Exception("Второе число введено не верно");
                        }
                    } else {
                        throw new Exception("Первое число введено не верно");
                    }
                } else if (!checkInput.isNumeric(inputUtil.getNumberOne()) && (!checkInput.isNumeric(inputUtil.getNumberTwo()))) {
                    numberOne = RomanNumeral.romanToArabic(inputUtil.getNumberOne());
                    numberTwo = RomanNumeral.romanToArabic(inputUtil.getNumberTwo());

                    if (numberOne < 11 && numberOne > 0) {
                        if (numberTwo > 0 && numberTwo < 11) {

                            int result = operationObj.result(numberOne, numberTwo, operation);
                            System.out.println(RomanNumeral.arabicToRoman(result));

                        } else {
                            throw new Exception("Второе число введено не вернj");
                        }
                    } else {
                        throw new Exception("Первое число введено не верно");
                    }
                }
            } catch (Exception e) {
                System.out.println("Неправильные входные данные - " + e.getMessage());
                break;
            }
        }
    }
}