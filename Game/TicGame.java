package Game;
import java.util.ArrayList;
import java.util.Scanner;

public class TicGame {  
    //save first insertion 
    //if statements

    ArrayList<ArrayList<Integer>> rows = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> coloums = new ArrayList<Integer>();
    static boolean isPlayer1 = true;
    static boolean isPlayer2=true;
    int[] row1 = new int[]{0, 0, 0}; 
    int[] row2 = new int[]{0, 0, 0}; 
    int[] row3 = new int[]{0, 0, 0}; 

    static int[][] board = {
        
        { 0, 0, 0}, 
        { 0, 0, 0}, 
        {0, 0, 0}, 
        
  };

    public static void main(String[] args) {
        CheckVertical();

  
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome");
        displayBoard();

        int enterchoice=100; 
        int row = 100;
        int coloum = 100;

        
        while (enterchoice != 0) {
          
            if ( isPlayer1) {
                System.out.println("First player turn");
                System.out.println("Enter the row number");
                row = input.nextInt();   
                System.out.println("Enter the coloum number");
                coloum = input.nextInt();  
                System.out.println("First player row number " + row + " and coloum " + coloum);
                
               
                if (board[row][coloum] == 0 ) {
                    board[row][coloum] = 1;
                    isPlayer1=false;
                    
                } else {
                    System.out.println("This position is not empty");
                }
            
            } else {
                
                System.out.println("Second player turn");
                System.out.println("Enter the row number");
                row = input.nextInt();   
                System.out.println("Enter the coloum number");
                coloum = input.nextInt();  
                System.out.println("Second player row number " + row + " and coloum " + coloum);

                if (board[row][coloum] == 0 ) {
                    board[row][coloum] = 2;
                    isPlayer1= true;
                    
                } else {
                    System.out.println("This position is not empty");
                }
            }
            displayBoard();
            boolean Win = CheckVertical() || CheckHorizontal() || CheckDiagonal();
            System.out.println(" You win " + Win);
            if (Win) {
                if (isPlayer1) {
                      System.out.println(" Second player won !!!");
                      System.out.println("Game over");
                } else {
                    System.out.println("First player won!!! ");
                    System.out.println("Game over");
                }
          
            enterchoice = 0;
            }
         }

        }
       public static void displayBoard(){

        for (int i = 0; i<3; i++) {
        for (int j = 0; j<3; j++) {
            System.out.print(" " + board[i][j]);
        }
        System.out.println();
    }
 }
   public static boolean CheckVertical(){
       
    boolean WinVertical= false;
    for (int i = 0; i < 3; i++) { //i - for each row 
    if (board[0][i] == board[1][i] && board[1][i] == board[2][i] &&  board[2][i] !=0) { //if values are the same 
        WinVertical = true;
        break;
    }
} 
        return WinVertical;
    }
    
     public static boolean CheckHorizontal() {
        boolean WinHorizonatal = false;
        for (int i = 0; i < 3; i++) { //i - for each row
        if (board[i][0] == board[i][1] && board[i][1] == board[i][2] &&  board[i][1] !=0) { //if values are the same 
            WinHorizonatal = true;
            break;
        }
     }
   
        return WinHorizonatal;
    }

    public static boolean CheckDiagonal() {
        boolean WinDiagonal = false;
       
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] &&  board[0][0] !=0) { //if values are the same 
            WinDiagonal= true;
          }

         if (board[0][2] == board[1][1] && board[1][1] == board[2][0] &&  board[2][0] !=0) { //if values are the same 
            WinDiagonal= true;

        }
    
        return WinDiagonal;
     }

    }

    

