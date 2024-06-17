public class  NumberGuessingGame {
    public static void main(String[] args) {
        int randomNumber= new Random().nextInt(10)+1;

        System.out.println(randomNumber);
        System.out.println("Please enter number from 1 to 10 inclusively: ");
    
   
        String gussedNumber = System.console().readLine();

    
    if(gussedNumber ==5){
        System.out.println("You gussed the number");

    }else if(gussedNumber !=5){
        System.out.println("You didn't guess the number");

    }
}}

    
