
import java.util.Scanner;
//balance, deposit, and withdraw money

public class ATMInterface {
    private static double balance = 0;
    private double withdraw = 0;
    private double deposit = 0;
    private double amount = 0;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("What kind of operation would you like to do?");

        int enterchoice = input.nextInt();    
        //if(userInput== balance){
            

    if (enterchoice == 1) {
        System.out.println("The balance is " + balanceCheck());       
      } else if (enterchoice == 2) {
        System.out.println("Enter an amount to withdraw ");
        double amount = input.nextDouble();
        //withdraw method
        withdraw(45);

      } else if (enterchoice == 3) {
        System.out.println("Enter an amount to deposit ");
        double amount = input.nextDouble();
        //deposit method
        deposit(50);
      } 
    }
    

        public static double balanceCheck(){
            return balance;

        }
        public static double deposit(double amount){
            return balance+=amount;
            
            
            
        }
        public static double withdraw(double amount){
            return balance-=amount;
            

        }


       
        
        
       
    
}
