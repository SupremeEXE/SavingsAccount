package bolt_shaun_savings;

/**
 *
 * @author RedOctober
 */
public class SavingsAccount 
{
    private double balance;     //Assigned variable for the balance of the user's account.
    private double annual_interest;     /*Assigened variable for the annual interest made
                                          on the user's account balance.
                                        */
    
    //Assigned class for the balance ammount and annual interest rate the user inputs.
    public SavingsAccount(double start)
    {
        balance = start;
        annual_interest = 0;
    }
    
    //Assigned class for the amount of money the user has taken out of their account each month.
    public void withdraw(double userAmount)
    {
        balance -= userAmount;
    }
    
    //Assigned class for the amount of money the user has put into their account each month.
    public void deposit(double userAmount)
    {
        balance += userAmount;
    }
    
    //Assigned class for the interest collected on the user's account balance each month.
    public double monthlyInterest()
    {
        double monthInt = ((annual_interest / 12) * balance);   //The math done for the monthly interest.
        balance += monthInt;    //Keeps the running total of the monthly interest on the user's account balance.
        return monthInt;    //Returns the value of the monthly interest made on the user's account balance.
    }
    
    //Assigned class for the annual interest rate inputed by the user for the year on their account.
    public void setAnnual(double interestRate)
    {
        annual_interest = interestRate / 100;   /*Does the math for the user inputing their annual
                                                  interest rate and automatically turns the whole number
                                                  rate into an annual interest rate percentage.
                                                */
    }
    
    //Assigned class for retrieving the ammount of the balance the user has entered.
    public double retrieve()
    {
        return balance;
    }
}