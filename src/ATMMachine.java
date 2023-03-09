import java.util.Scanner;
import java.util.ArrayList;

public class ATMMachine {
    // VARIABLES //

    String userName;
    String firstName;
    String lastName;
    String city = " ";
    String state = " ";
    String zipCode = " ";
    String country = " ";
    String addressLn1 = " ";
    String addressLn2 = " ";
    double balanceAmount = 90000;
    double withdrawAmount;
    double depositAmount;

    // CONSTRUCTOR //
    public ATMMachine() {
        this.userName = firstName + " " + lastName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.addressLn1 = addressLn1;
        this.addressLn2 = addressLn2;
        this.balanceAmount = balanceAmount;
        this.withdrawAmount = withdrawAmount;
        this.depositAmount = depositAmount;
    }

    // INITIALIZING METHOD //
    public void letsBegin() {
        System.out.println(MenuStyling.printBannerTop());
        System.out.print(
                MenuStyling.centerString("Welcome to BANK ATM $IMULATOR.") +
                        MenuStyling.centerString("Type your first and last name below") +
                        MenuStyling.centerString("Then press the ENTER key"));
        System.out.println(MenuStyling.printBannerBottom());
        System.out.println('\n');

        // these two lines below create a scanner called keyboard and assign
        // it to the new Scanner that takes in info from the user
        Scanner keyboard = new Scanner(System.in);
        this.firstName = keyboard.next();
        this.lastName = keyboard.next();
        this.userName = this.firstName + " " + this.lastName;

        System.out.println("Your name is saved as: " + this.userName.toUpperCase() + ".");
        System.out.println("Tip: You can change your name later.");
        printMainMenuScreen();
    }

    // ADDITIONAL METHODS //
    public void printMainMenuScreen() {
        System.out.println(MenuStyling.printBannerTop());
        System.out.print(MenuStyling.centerString("main menu".toUpperCase()));
        System.out.println(MenuStyling.currentBalHeader(this.firstName, " ", this.balanceAmount));
        System.out.println(MenuStyling.paddingString("recent transactions", ".", "Press '1'"));
        System.out.println(MenuStyling.paddingString("withdraw/deposit", ".", "Press '2'"));
        System.out.println(MenuStyling.paddingString("view/change account details", ".", "Press '3'"));
        System.out.println(MenuStyling.paddingString("end session", ".", "Press '4'"));
        System.out.println(MenuStyling.printBannerBottom());

        // contains a scanner for the main menu
        mainMenuSwitchStatement();
    }

    public void printRecentTransactionsMenuScreen() {
        System.out.println(MenuStyling.printBannerTop());
        System.out.println(MenuStyling.centerString("recent transactions").toUpperCase());
        System.out.println(MenuStyling.currentBalHeader(this.firstName, " ", this.balanceAmount));

        if ((this.withdrawAmount == 0.0) && (this.depositAmount == 0.0)) {
            System.out.println(MenuStyling.centerString("There are no recent transactions for this account"));
        } else {
            System.out.println(MenuStyling.transactionFormatting("Withdrawal", ".", this.withdrawAmount));
            System.out.println(MenuStyling.transactionFormatting("deposit", ".", this.depositAmount));
        }
        System.out.println(MenuStyling.paddingString("return to main menu", ".", "Press '1'"));
        System.out.println(MenuStyling.paddingString("end session", ".", "Press '2'"));
        System.out.println(MenuStyling.printBannerBottom());
        // create a switch statement and put it below
        recentTransactionsSwitchStatement();
    }

    public void printWithdrawDepositMenuScreen() {
        System.out.println(MenuStyling.printBannerTop());
        System.out.println(MenuStyling.centerString("withdraw/deposit").toUpperCase());
        System.out.println(MenuStyling.currentBalHeader(this.firstName, " ", this.balanceAmount));
        System.out.println(MenuStyling.paddingString("withdraw funds", ".", "Press '1'"));
        System.out.println(MenuStyling.paddingString("deposit funds", ".", "Press '2'"));
        System.out.println(MenuStyling.paddingString("return to main menu", ".", "Press '3'"));
        System.out.println(MenuStyling.paddingString("end session", ".", "Press '4'"));
        System.out.println(MenuStyling.printBannerBottom());

        // create a switch statement and put it below()
        withdrawDepositSwitchStatement();
    }

    public void printViewChangeAccountDetailsMenuScreen() {
        // THIS IS WHERE THE UPDATE YOUR USERNAME function should be placed
        System.out.println(MenuStyling.printBannerTop());
        System.out.print(MenuStyling.centerString("View/Update Account Details".toUpperCase()));
        System.out.println(MenuStyling.currentBalHeader(this.firstName + " " + this.lastName, " ", this.balanceAmount));
        if (this.addressLn1.length() <= 1) {
            System.out.println(MenuStyling.paddingString("No address on file for this account.", " ", " "));

        } else {
            printAddressBlock();
        }
        System.out.println();
        System.out.println(MenuStyling.paddingString("Update name", ".", "Press '1'"));
        System.out.println(MenuStyling.paddingString("update address", ".", "Press '2'"));
        System.out.println(MenuStyling.paddingString("Return to main menu", ".", "Press '3'"));
        System.out.println(MenuStyling.paddingString("end session", ".", "Press '4'"));
        System.out.println(MenuStyling.printBannerBottom());
        accountDetailsSwitchStatement();
    }

    public void printEndSessionScreen() {
        System.out.println(MenuStyling.printBannerTop());
        System.out.print(
                MenuStyling.centerString("Thank you, " + this.firstName.toUpperCase()) +
                        MenuStyling.centerString("for using BANK ATM $IMULATOR") + '\n' +
                        MenuStyling.centerString("Goodbye!"));
        System.out.println(MenuStyling.printBannerBottom());
    }

    public void printErrorMessageScreen() {
        System.out.println(MenuStyling.printBannerTop());
        System.out.println(MenuStyling.centerString("oops!".toUpperCase()));
        System.out.println(MenuStyling.centerString("The option you selected was invalid."));
        System.out.println(MenuStyling.paddingString("Main Menu".toUpperCase(), " ", "End Session ".toUpperCase()));
        System.out.println(MenuStyling.paddingString("Press '1'", " ", "Press '2'   "));
        System.out.println(MenuStyling.printBannerBottom());

        // contains a scanner for the error menu
        errorMessageSwitchStatement();

    }

    // SWITCH STATEMENT METHODS
    public void mainMenuSwitchStatement() {
        // put a scanner method here to listen in for what number the user presses
        Scanner keyboard = new Scanner(System.in);
        int menuItem = keyboard.nextInt();

        switch (menuItem) {
            case 1: {
                // recent transactions
                printRecentTransactionsMenuScreen();
                break;
            }
            case 2: {
                // withdraw/deposit funds
                printWithdrawDepositMenuScreen();
                break;
            }
            case 3: {
                // view/change account details
                printViewChangeAccountDetailsMenuScreen();
                break;
            }
            case 4: {
                // end session
                printEndSessionScreen();
                break;
            }
            default: {
                printErrorMessageScreen();
            }
        }

    }

    public void accountDetailsSwitchStatement() {
        // put a scanner here to listen in for what number the user presses
        Scanner keyboard = new Scanner(System.in);
        int menuItem = keyboard.nextInt();

        switch (menuItem) {
            case 1: // UPDATE USERNAME
            {
                printUpdateNameInfo();
                break;
            }
            case 2: // UPDATE ADDRESS
            {
                printUpdateAddressInfo();
                break;
            }
            case 3: {
                // MAIN MENU
                printMainMenuScreen();
                break;
            }
            case 4: {
                // END SESSION
                printEndSessionScreen();
                break;
            }
            default: {
                printErrorMessageScreen();
            }
        }

    }

    public void errorMessageSwitchStatement() {
        // put a scanner here to listen in for what number the user presses
        Scanner keyboard = new Scanner(System.in);
        int menuItem = keyboard.nextInt();

        switch (menuItem) {
            case 1: {
                // MAIN MENU
                printMainMenuScreen();
                break;
            }
            case 2: {
                // END SESSION
                printEndSessionScreen();
                break;
            }
            default: {
                printErrorMessageScreen();
            }
        }

    }

    public void withdrawDepositSwitchStatement() {
        Scanner keyboard = new Scanner(System.in);
        int menuItem = keyboard.nextInt();

        switch (menuItem) {
            case 1: {
                // WITHDRAW
                withdrawCalculator();
                break;
            }
            case 2: {
                // DEPOSIT
                depositCalculator();
                break;
            }
            case 3: {
                // MAIN MENU
                printMainMenuScreen();
                break;
            }
            case 4: {
                // END SESSION
                printEndSessionScreen();
                break;
            }
            default: {
                printErrorMessageScreen();
            }
        }

    }

    public void recentTransactionsSwitchStatement() {
        Scanner keyboard = new Scanner(System.in);
        int menuItem = keyboard.nextInt();

        switch (menuItem) {
            case 1: {
                // MAIN MENU
                printMainMenuScreen();
                break;
            }
            case 2: {
                // END SESSION
                printEndSessionScreen();
                break;
            }
            default: {
                printErrorMessageScreen();
            }
        }

    }

    // OTHER METHODS //
    public void printUpdateAddressInfo() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Address line 1: ");
        this.addressLn1 = keyboard.nextLine();

        Scanner keyboard1 = new Scanner(System.in);
        System.out.println("Address line 2: ");
        this.addressLn2 = keyboard1.nextLine();

        Scanner keyboard2 = new Scanner(System.in);
        System.out.println("City: ");
        this.city = keyboard2.nextLine();

        Scanner keyboard3 = new Scanner(System.in);
        System.out.println("State: ");
        this.state = keyboard3.nextLine();

        Scanner keyboard4 = new Scanner(System.in);
        System.out.println("Zip Code: ");
        this.zipCode = keyboard4.nextLine();

        Scanner keyboard5 = new Scanner(System.in);
        System.out.println("Country: ");
        this.country = keyboard5.nextLine();

        System.out.println("\nYour account details have been updated.");
        printViewChangeAccountDetailsMenuScreen();
    }

    public void printUpdateNameInfo() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("First Name: ");
        firstName = keyboard.nextLine();

        Scanner keyboard1 = new Scanner(System.in);
        System.out.println("Last Name: ");
        lastName = keyboard1.nextLine();

        userName = firstName + " " + lastName;

        System.out.println("Your account details have been updated:");
        printViewChangeAccountDetailsMenuScreen();
    }

    public void printAddressBlock() {
        String addressLn3 = this.city + ", " + this.state + ", " + this.zipCode + ", " + this.country;

        // two versions of address block, one with address line 2 and another without
        String addressBlock1 = this.addressLn1 + '\n' + " " + addressLn3;
        String addressBlock2 = this.addressLn1 + '\n' + " " + this.addressLn2 + '\n' + " " + addressLn3;

        // if addressLn2's length is null or less than or equal to 1, print the
        // addressblock version without ln 2. Otherwise, print it with addressLn2
        if (this.addressLn2.length() <= 1) {
            System.out.println(MenuStyling.paddingString(addressBlock1, " ", " "));
        } else {
            System.out.println(MenuStyling.paddingString(addressBlock2, " ", " "));
        }
    }

    public void withdrawCalculator() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("How much would you like to withdraw?");
        double withdrawAmount = Math.abs(keyboard.nextDouble());

        if (this.balanceAmount >= withdrawAmount) {
            this.balanceAmount = (this.balanceAmount - withdrawAmount);
            System.out.println("withdrawal of $" + withdrawAmount + " was successful.");
            System.out.println("Would you like to make another transaction?");
        } else {
            System.out.println("Insufficient funds.");
            System.out.println("withdrawal of $" + withdrawAmount + " was unsuccessful due to insufficient funds.");
            System.out.println("Would you like to make another transaction?");
        }
        printWithdrawDepositMenuScreen();
    }

    public void depositCalculator() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("How much would you like to deposit? ");
        double depositAmount = Math.abs(keyboard.nextDouble());
        this.balanceAmount = (this.balanceAmount + depositAmount);

        System.out.println("Deposit of $" + depositAmount + " was successful.");
        System.out.println("Would you like to make another transaction?");
        printWithdrawDepositMenuScreen();
    }

    @Override
    public String toString() {
        return "ATMMachine{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                ", addressLn1='" + addressLn1 + '\'' +
                ", addressLn2='" + addressLn2 + '\'' +
                ", balanceAmount=" + balanceAmount +
                ", withdrawAmount=" + withdrawAmount +
                ", depositAmount=" + depositAmount +
                '}';
    }
}