

public class CountVowels {
        //Count Vowels in a String: Develop a program that counts the 
    //number of vowels in a given string. 
    //This will help in understanding string manipulation and the use 
    //of loops and conditionals.


    //A, E, I, O, U, and sometimes Y

    public static void main(String[] args) {
        String input= "Adeliya".toLowerCase();
        
        System.out.println(CountVowels(input));


    }

    public static int CountVowels(String input){
       int vowelsCounter=0;
       
       for (int i = 0; i <input.length(); i++) {
       char ch= input.charAt(i);
       if(ch =='a' || ch  == 'e'||ch =='i'||ch =='o'||ch =='u'){
            vowelsCounter++;
        }
         
    }
    return vowelsCounter;

}}
        

                