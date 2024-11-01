public class TodoManager {
    
    public static void saveTasksToFile(String filePath, List<ToDo> tasks) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
    for (ToDo task : tasks) {
    writer.write(task.toString());
    writer.newLine();
    }
    }
    }
    public static List<ToDo> loadTasksFromFile(String filePath) throws IOException {
    List<ToDo> tasks = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
    String line;
    while ((line = reader.readLine()) != null) {
    tasks.add(ToDo.fromString(line));
    }
    }
    return tasks;
    }
    public static void markTaskAsComplete(int id, String filePath) throws IOException {
    List<ToDo> tasks = loadTasksFromFile(filePath);
    for (ToDo task : tasks) {
    if (task.getId() == id) {
    task.setComplete(true);
    break;
    }
    }
    saveTasksToFile(filePath, tasks);
    }
    public static void displayTasks(List<ToDo> tasks) {
    for (ToDo task : tasks) {
    System.out.println("ID: " + task.getId() + ", Task: " + task.getTask() + ", Complete: " +
    task.isComplete());
    }
    }
    }
    
}
