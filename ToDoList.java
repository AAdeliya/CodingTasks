import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    public static ArrayList<String> tasks= new ArrayList<String>();
    
    public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
    int enterchoice = 9;  

while (enterchoice != 0) {
    System.out.println("Select one option: " );
    System.out.println("1.CREATE" );
    System.out.println("2.READ" );
    System.out.println("3.UPDATE" );
    System.out.println("4.DELETE" );
    enterchoice = input.nextInt();   

    if (enterchoice ==1) {
        System.out.println("Enter the task");
        String task = input.next();
        System.out.println("You added new task to the to-do list: " + task);
        create(task);
    } else if (enterchoice == 2) {
        read();
    } else if(enterchoice == 4) {
        System.out.println("Enter the task that you want to delete: " ); 
        String task = input.next();
        delete(task);
    }
}
}

      public static void create(String task) {
      tasks.add(task);
    } 

       public static void read() {
       for (String  task : tasks) {
        System.out.println(task);
    }
    
}
        public static void delete(String taskToDelete) {
    
    if (tasks.isEmpty()) {
        System.out.println("You don't have tasks in the list!");

    } else {
         for (String task : tasks) {
            
            if (task.equals(taskToDelete)) {
            tasks.remove(taskToDelete);
            break;
        } else {
            System.out.println("You don't have this task in the list");
        }
    }
 }

}

}
   
   