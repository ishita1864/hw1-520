// public class InputValidation {
    
// }

public class InputValidation {
    public static boolean isValidAmount(Double input) {
        try {
            //double amount = Double.parseDouble(input);
            double amount = input;
            return amount > 0 && amount < 1000;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidCategory(String category) {
        String[] validCategories = {"food", "travel", "bills", "entertainment", "other"};
        for (String validCategory : validCategories) {
            if (validCategory.equalsIgnoreCase(category)) {
                return true;
            }
        }
        return false;
    }
}
