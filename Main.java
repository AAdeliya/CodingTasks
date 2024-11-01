public public class Main {
    public static void main(String[] args) {
    String filePath = "tasks.txt";
    List<ToDo> tasks = new ArrayList<>();
    // Creating sample tasks
    tasks.add(new ToDo(1, "Buy groceries", false));
    tasks.add(new ToDo(2, "Finish homework", false));
    tasks.add(new ToDo(3, "Call the bank", true));
    try {
    // Saving tasks to file
    ToDoManager.saveTasksToFile(filePath, tasks);
    System.out.println("Tasks saved to file.");
    // Loading and displaying tasks from file
    List<ToDo> loadedTasks = ToDoManager.loadTasksFromFile(filePath);
    System.out.println("Loaded tasks:");
    ToDoManager.displayTasks(loadedTasks);
    // Marking a task as complete
    ToDoManager.markTaskAsComplete(2, filePath);
    System.out.println("\nUpdated tasks after marking ID 2 as complete:");
    loadedTasks = ToDoManager.loadTasksFromFile(filePath);
    ToDoManager.displayTasks(loadedTasks);
    } catch (IOException e) {
    System.err.println("Error handling file: " + e.getMessage());
    }
    }
    }
    
   
