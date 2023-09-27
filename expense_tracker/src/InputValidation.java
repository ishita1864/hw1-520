/**
 * The InputValidation class allows the system to validate the input, to satisfy the following criteria:
 * The amount should be greater than 0 and less than 1000.
 * It should be a valid number, check for invalid inputs of other data types.
 * The category should be a valid string input from the following list: ”food”, ”travel”, ”bills”, ”entertain- ment”, and ”other”.
 */


public class InputValidation {

    //Validate if the input number is between 0 and 1000
    public static boolean isValidAmount(Double input) {
        try {
            double amount = input;
            return amount > 0 && amount < 1000;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //Validate if the input category is in the list: "food", "travel", "bills", "entertainment", "other"
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
