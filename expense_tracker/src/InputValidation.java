public class InputValidation {

    public static boolean validAmount(double amount) {
        return amount < 1000 && amount > 0
    }

    public static boolean validCategory(String category){
        String[] validCategories = {"food", "travel", "bills", "entertainment", "other"};
        
        for(String i : validCategories){
            if(i.equalsIgnoreCase(category)){
                return true;
            }
        }
        return false;
    }

    public static String validInputs(double amount, String category) {
        if (!validAmount(amount)) {
            return "Invalid Amount";
        }
        if (!validCategory(category)) {
            return "Invalid Category";
        }
        return "Valid inputs";
    }
}

