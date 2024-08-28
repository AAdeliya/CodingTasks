public class StringReverser {
    
    public static void main(String[] args) {
        String input = "Adeliya";
        String output = "";
        char ch;

        for (int i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            output = ch+output;
            
        }
        System.out.println("This is input" + input + " and here is reversed version " + output);
    }
}

    
