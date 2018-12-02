package bolt_shaun_savings;
import javax.swing.JOptionPane;

/*
Project/Assignment Title: SavingsAccount Class
File Name: bolt_shaun_savings
Data Complied Last: November 25, 2018
Author: Shaun Bolt
Complied in: NetBeans 8.2
Integrity Statement: By submitting this project, I am taking the integrity oath
that I have not copied any line(s) of code - partially or completely - from any
other individual, former student work, textbook, online resources, website, and
any reference avaliable anywhere.
 * @author shabolt
 */
public class Bolt_Shaun_Savings 
{
    public static void main(String[] args) 
    {
        String input;   //Allows the user to input information about their account.
        double annual = 0;  /*The input variable that holds the value of what the 
                          user's current annual interest rate is at the time.
                        */
        double userBalance = 0; //Holds the value of the user's balance that they input in.
        int months = 0;     /*Holds the value of the number of months it has been since
                          the user has started their account.
                        */
        double store = 0; /*Holds the value of the ammount of money the user is
                          adding to their account.
                        */
        double takeout = 0; /*Holds the value of the ammount of money the user is
                          taking out of their account.
                         */
        double sumTotal = 0; /*Holds the value of the total amount of money the
                               user has deposited into the account.
                             */
        double diffTotal = 0; /*Holds the value of the total amount of money the
                               user has withdrawed from the account.
                             */
        double interestTotal = 0; /*Holds the value of the total amount of interest
                                    earned on the balance in the user's account.
                                  */
        
        /*Data validation so that a user can not enter a negative annual interest rate
          or input an annual interest rate that is above 250% since that is not possible.
        */
        while(annual < 1 || annual > 250)
        {
            //Allows the user to input what their current annual interest rate is.
            input = JOptionPane.showInputDialog("Please enter your current annual interest rate: ");
            annual = Double.parseDouble(input);
        }
        
        /*Date validation so that the user can not input a negative balance; there is no
          cap on the amount of money the user can input as their balance.
        */
        do
        {
            //Allows the user to input the ammount of money they are putting into their account.
            input = JOptionPane.showInputDialog("Please enter the amount you want to put into your balance: ");
            userBalance = Double.parseDouble(input);
        }
        while(userBalance < 0);
        
        /*Date validation so that the user can not input a negative number of month(s); there is no
          cap on the number of months the user can input for how long they have had their account.
        */
        while(months < 1)
        {
            //Allows the user to input the number of months they have had their account.
            input = JOptionPane.showInputDialog("Please enter how many months you have had this account: ");
            months = Integer.parseInt(input);
        }
        
        //Calling the class assigned to the user's account balance.
        SavingsAccount amount = new SavingsAccount(userBalance);
        
        //Calling the class assigned to the annual interest rate the user inputs.
        amount.setAnnual(annual);
        
        
        /*The 'for' loop that controls the running total on the user's account balance,
          the amount deposited and withdrawed, and the running total on the interest
          made on the user's account balance.
        */
        for( int presentMonth = 1; presentMonth <= months; presentMonth++ )
        {
            /*Data validation so that the user can not input a negative deposit amount. 
              There is no cap on the amount of money the user can deposit each month into their
              account.
            */
            do
            {
                //Allows the user to input the amount of money they deposited each month.
                input = JOptionPane.showInputDialog("How much money did you deposit during month " + presentMonth);
                store = Double.parseDouble(input);
            }
            while(store < 0);
            
            sumTotal += store;    //The running total on the deposits made into the account.

            amount.deposit(store);    //Calling the class assigned to amount being put into the balance.
            
            userBalance = amount.retrieve();

            /*Data validation so that the user can not input a negative withdraw amount. 
              The cap amount the user can withdraw from their account depends on how
              much money they still have in their account.
            */
            do
            {
                if(takeout > -1 || takeout < userBalance)
                {
                    //Allows the user to input the amount of money they withdrawed each month.
                    input = JOptionPane.showInputDialog("How much money did you withdraw during month " + presentMonth);
                    takeout = Double.parseDouble(input);
                }
                else
                {
                    //Error message for when the user withdraws more money than what they have in their account.
                    JOptionPane.showMessageDialog(null, "Please enter amount less than or equal to this amount: $" + userBalance);
                }
            }
            while(takeout < 0 || takeout > userBalance);
            
            diffTotal += takeout;  //The running total on the withdraws made from the account.

            amount.withdraw(takeout);  //Calling the class assigned to amount taken from the balance.
            
            userBalance = amount.retrieve();    //Second one needed to avoid negative balance and/or interest.
            
            /*Calling the class assigned to the monthly interest on the account's balance
              and keeping a running total on the amount of interest made on the account's balance.
            */
            interestTotal += amount.monthlyInterest();
        }
        
        //Displays what the ending balance is in the user's savings account.
        JOptionPane.showMessageDialog(null, String.format("Your balance after %d " +
                " months is: $%.2f", months, amount.retrieve()));
        
        //Displays the total amount desposited into the savings account.
        JOptionPane.showMessageDialog(null, String.format("The total amount deposited " + 
                "into your account is: $%.2f", sumTotal));
        
        //Displays the total amount withdrawed from the savings account. 
        JOptionPane.showMessageDialog(null, String.format("The total amount of withdrawls " + 
                "from your account is: $%.2f", diffTotal));
        
        //Displays the total amount of interest the savings account has made.
        JOptionPane.showMessageDialog(null, String.format("The total ammount of interest " + 
                "earned on the account is: $%.2f", interestTotal));
    }
}