import java.util.Scanner;


public class ATMInterface {
    private static double balance = 0;
    private double withdraw = 0;
    private double deposit = 0;
    public static double amount = 0;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int enterchoice=9;  //any number 

        while(enterchoice != 0)  {
        System.out.println("What kind of operation would you like to do?");
        enterchoice = input.nextInt();   
        
        if (enterchoice == 1) {
            System.out.println("The balance is " + balanceCheck());       
          } else if (enterchoice == 2) {
            System.out.println("Enter an amount to withdraw ");
            amount = input.nextDouble();
            //withdraw method
            System.out.println("The balance is " + withdraw(amount));       
            
          } else if (enterchoice == 3) {
            System.out.println("Enter an amount to deposit ");
            amount = input.nextDouble();
            //deposit method
            System.out.println("The balance is " + deposit(amount));       
           
          } 

        }
        
    }
    
    public static double balanceCheck() {
            return balance;

        }
        
    public static double deposit(double amount) {
            return balance+=amount;
        }

    public static double withdraw(double amount) {
            return balance-=amount;
        }


       
        
        
       
    
}
