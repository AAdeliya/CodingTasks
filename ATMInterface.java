
import java.util.Scanner;
//balance, deposit, and withdraw money

public class ATMInterface {
    int balance = 1000;
    String  deposit;
    String  withdraw;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("What kind of operation would you like to do?");

        //int balance = userInput.nextInt();
        //if(userInput== balance){
            //

    }

        public int balanceCheck(){
            System.out.println("Your balance is :" + balance);
            return balance;

        }
        public int deposit(int d){
            balance+=d;
            System.out.println("Your balance is updated : " + balance);
            return balance;
            
        }
        public int withdraw(int w){
            balance-=w;
            System.out.println("Your balance is updated : " + balance);
            return balance;

        }


       
        
        
       
    
}
