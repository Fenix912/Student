package Kalkulator_Arabskie_Rimskie;

public class CheckInput {
    // проверка ввода отпользователя что число является арабским

    public boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}