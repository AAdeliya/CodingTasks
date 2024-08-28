public class CountVowels {
    
    public static void main(String[] args) {
        String input= "Adeliya".toLowerCase();
        System.out.println(CountVowels(input));
    }

    public static int CountVowels(String input) {
       int vowelsCounter=0;
       for (int i = 0; i <input.length(); i++) {
       char ch= input.charAt(i);
       if (ch =='a' || ch  == 'e'||ch =='i'||ch =='o'||ch =='u') {
            vowelsCounter++;
        }
         
    }

    return vowelsCounter;

}

}
        

                