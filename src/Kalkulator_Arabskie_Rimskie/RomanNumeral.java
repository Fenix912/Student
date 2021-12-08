package Kalkulator_Arabskie_Rimskie;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


    public enum RomanNumeral {
        I(1), IV(4), V(5), IX(9), X(10),
        XL(40), L(50), XC(90), C(100);

        private final int value;

        RomanNumeral(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }


        public static List getReverseSortedValues() {
            return Arrays.stream(values())
                    .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
                    .collect(Collectors.toList());
        }

        public static int romanToArabic(String input) {
            String romanNumeral = input.toUpperCase();
            int result = 0;
            // создание листа
            List romanNumerals = RomanNumeral.getReverseSortedValues();

            int i = 0;

            while ((romanNumeral.length() > 0) && (romanNumerals.size() > i)) {
                RomanNumeral symbol = (RomanNumeral) romanNumerals.get(i);
                if (romanNumeral.startsWith(symbol.name())) {
                    result += symbol.getValue();
                    romanNumeral = romanNumeral.substring(symbol.name().length());
                } else {
                    i++;
                }
            }
            if (romanNumeral.length() > 0) {
                throw new IllegalArgumentException(input + "Данные не верные, не могут быть преобразованы");
            }
            return result;
        }

        public static String arabicToRoman(int number) {
            if ((number <= 0) || (number > 101)) {
                throw new IllegalArgumentException(number + " вне диапазона (0,101)");
            }

            List romanNumerals = RomanNumeral.getReverseSortedValues();

            int i = 0;
            StringBuilder sb = new StringBuilder();

            while ((number > 0) && (i < romanNumerals.size())) {
                RomanNumeral currentSymbol = (RomanNumeral) romanNumerals.get(i);
                if (currentSymbol.getValue() <= number) {
                    sb.append(currentSymbol.name());
                    number -= currentSymbol.getValue();
                } else {
                    i++;
                }
            }
            return sb.toString();
        }
    }