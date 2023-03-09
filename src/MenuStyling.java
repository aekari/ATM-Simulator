public class MenuStyling {

    public MenuStyling() {
        // there is nothing here because there's no need!
    }

    // other Methods
    public static String currentBalHeader(String leftText, String paddingSymbol, double rightText) {
        // available space is set to the length of whatever the printBannerTop() length
        // is
        // the adjustments variable is needed to account for the added characters that
        // must be
        // taking in other characters I'm not seeing
        String label = "Bal: $".toUpperCase();
        int adjustments = 6;
        int availableSpace = printBannerTop().length();
        int leftAndRight = leftText.length() + label.length() + Double.toString(rightText).length();
        // I have a new padding variable here to hold the value of paddingSymbol,
        // unchanged
        String newPadding = paddingSymbol;

        // This is the for loop that adds the correct amount of spaces between the left
        // side of the text to justify it
        for (int i = 0; i <= ((availableSpace - leftAndRight) - adjustments); ++i) {
            // paddingSymbol changes here each time which is why
            // newPadding var exists, unchanged. otherwise the math is wrong;
            paddingSymbol += newPadding;
        }
        return " " + leftText.toUpperCase() + paddingSymbol + label + rightText + "\n";
    }

    public static String rightPaddingOnly(String paddingSymbol, String rightText) {
        // the amount of total available space is equal to printBannerTop().length
        int availableSpace = printBannerTop().length();
        // I have a new padding variable here to hold the value of paddingSymbol,
        // unchanged
        String newPadding = paddingSymbol;
        // This is a variable to make up for any small calculation errors
        int adjustments = 1;

        // This is the for loop that adds the correct amount of spaces between the left
        // side of the text to justify it
        for (int i = 0; i <= ((availableSpace - rightText.length()) - adjustments); ++i) {
            // paddingSymbol changes here each time which is why
            // newPadding var exists, unchanged as a local variable. Otherwise, I think it
            // would square padding symbol
            // instead of adding just 1 instance of padding to padding.
            paddingSymbol += newPadding;
        }
        return paddingSymbol + rightText + " ";
    }

    // should this be in ATMMACHINE? and called TransactionCalc, and do the styling
    // here but separate into
    // two different functions
    public static String transactionFormatting(String transactDescription, String paddingSymbol, double amount) {
        // this will style the transactions automatically when the user makes deposits
        // and withdraws cash
        // might need an if statement:
        // if the amount is lower than the balance, do this:
        // if balance is equal to the current balance, do this:
        // if the variable isEmpty(), then do this: print out no recent transactions on
        // file
        // RETURN in a styled format? so that it can be called in the transact menu

        // available space is set to the length of whatever the printBannerTop() length
        // is
        // the adjustments variable is needed to account for the added characters being
        // returned that aren't in the for loop
        int adjustments = 7;
        int availableSpace = printBannerTop().length();
        // Double.toString(amount).length() means, "I have a double that I want
        // converted to a String called amount."
        // Then I use the "." to say, do the length() method on amount, now that it has
        // been converted to a String.
        int leftAndRight = transactDescription.length() + Double.toString(amount).length();
        // I have a new padding variable here to hold the value of paddingSymbol,
        // unchanged
        String newPadding = paddingSymbol;

        // This is the for loop that adds the correct amount of spaces between the left
        // side of the text to justify it
        for (int i = 0; i <= ((availableSpace - leftAndRight) - adjustments); ++i) {
            // paddingSymbol changes here each time which is why
            // newPadding var exists, unchanged. otherwise the math is wrong;
            paddingSymbol += newPadding;
        }
        return " " + transactDescription.toUpperCase() + paddingSymbol + "$" + amount;
    }

    // public String padding3Strings(String leftText , String centerText , String
    // rightText, String paddingSymbol){
    //
    // // available space is set to the length of whatever the printBannerTop()
    // length is
    // int availableSpace = printBannerTop().length();
    // // the adjustments variable is needed to account for the added characters
    // that must be
    // // taking in other characters I'm not seeing
    // int adjustments = 0;
    //
    // int leftCenterRight = leftText.length() + centerText.length() +
    // rightText.length();
    // // I have a new padding variable here to hold the value of paddingSymbol,
    // unchanged
    // String newPadding = paddingSymbol;
    //
    // // to get the correct amount of padding without creating 2 variables, take
    // the total
    // // available space and subtract that from left center right. Because we need
    // padding in two even spaces,
    // // divide it by two. subtract that amount from adjustments and that's how
    // much padding you'll need
    // for (int i = 0; i <= (((availableSpace - leftCenterRight)/ 2) - adjustments);
    // ++i)
    // {
    // // paddingSymbol changes here each time which is why
    // // newPadding var exists, unchanged. otherwise the math is wrong;
    // paddingSymbol += newPadding;
    // }
    // //do I want any .toUpperCase() here or keep it in ATM Machine?
    // return " " + leftText.toUpperCase() + paddingSymbol +
    // centerText.toUpperCase() + paddingSymbol +rightText.toUpperCase();
    // }

    public static String paddingString(String leftText, String paddingSymbol, String rightText) {
        // available space is set to the length of whatever the printBannerTop() length
        // is
        // the adjustments variable is needed to account for the added characters that
        // must be
        // taking in other characters I'm not seeing (margin of error)
        int adjustments = 5;
        int availableSpace = printBannerTop().length();
        int leftAndRight = leftText.length() + rightText.length();
        // I have a new padding variable here to hold the value of paddingSymbol,
        // unchanged
        String newPadding = paddingSymbol;

        // This is the for loop that adds the correct amount of spaces between the left
        // side of the text to justify it
        for (int i = 0; i <= ((availableSpace - leftAndRight) - adjustments); ++i) {
            // paddingSymbol changes here each time which is why
            // newPadding var exists, unchanged. otherwise the math is wrong;
            paddingSymbol += newPadding;
        }
        return " " + leftText.toUpperCase() + paddingSymbol + rightText;
    }

    public static String centerString(String anyString) {

        // This is the equation to center text within the menu
        int stringLength = ((printBannerTop().length() / 2) - anyString.length()) + (anyString.length() / 2);

        // This is the for loop that adds the correct amount of spaces to the left side
        // of the text to center it
        for (int i = 0; i < stringLength; i++) {
            String padding = " ";
            anyString = padding + anyString;
        }

        // Return the title (now with padding) and create a new line
        return anyString + "\n";
    }

    public static String printBannerTop() {
        return "╔════════════════════ ∘◦ $$$$ ◦∘ ════════════════════╗\n";
    }

    public static String printBannerBottom() {
        return "\n╚════════════════════════════════════════════════════╝\n";
    }
}
