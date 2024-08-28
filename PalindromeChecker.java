public class PalindromeChecker {
    public static void main(String[] args) {
       System.out.println(IsPalindranomic("kssk"));
    }

     public static boolean IsPalindranomic(String input) { 
        int leftPointer=0; //start
        int rightPointer=input.length()-1; //end

        while (leftPointer<rightPointer) {

            if (input.charAt(leftPointer)!= input.charAt(rightPointer)) {
                return false;
            }

            leftPointer++;
            rightPointer--;

        }
        return true;
    }

}
