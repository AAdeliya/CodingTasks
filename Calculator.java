public class Calculator {
    public static void main(String[] args) {
        additon(4, 5);
        substraction(10, 5);
        multiplication(2,4);
        divition(10, 2);
    
    
    
    //Basic Calculator: Create a program that takes two numbers as inputs and performs basic arithmetic operations
    // (addition, subtraction, multiplication, division).
    // This introduces the concept of variables, user input, and basic arithmetic operations.//
    }
    public static int additon(int a, int b){
        a += b;
        System.out.println("Result of addiiton: " + a );
        return a;
    }
    public static int substraction(int a, int b){
        a-=b;
        System.out.println("Result of substruction: " + a);
        return a;
    }
    public static int multiplication(int a, int b){
        a*=b;
        System.out.println("Result of multiplication: " + a);
        return a;
    }
    public static int divition(int a, int b){
        a/=b;
        System.out.println("Result of divition: " + a);
        return a;
    }
    
}
