    public class TemperatureConverter {
    //C= (n(F)-32)*5/9

    //°F = (9/5 × °C) + 32
    public static void main(String[] args) {
        Fahrenheit(25);
        Celcia(74);
     }
     
     public static void Fahrenheit(int n) {
        int  F=(9/5 * n) + 32;
        System.out.println(n+ " Celcia in " +  "Fahrenheir: " + F);
    }

     public static void Celcia(int n) {
         int C=(n-32)*5/9;
         System.out.println(n+ " Fahrenheir in " +  "Celcia: " + C);
 
     }
    
 }
 