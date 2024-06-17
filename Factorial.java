public class Factorial {
    public static int Factorial( int n){
        int result= 1;


        for (int i = 2; i <= n; i++) {
            result*=i;
     
        }
        return result;
        
    }

    public static void main(String[] args) {
        int result = Factorial(7);

        
        System.out.println("Factorial of %d is: " + result );
        
    }
    
}

    
