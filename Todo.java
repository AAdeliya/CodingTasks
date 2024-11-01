public class Todo {
    
    private int id;
    private String task;
    private boolean isComplete;
    public ToDo(int id, String task, boolean isComplete) {
    this.id = id;
    this.task = task;
    this.isComplete = isComplete;
    }
    public int getId() {
    return id;
    }
    public String getTask() {
    return task;
    }
    public boolean isComplete() {
    return isComplete;
    }
    public void setComplete(boolean complete) {
    isComplete = complete;
    }
    @Override
    public String toString() {
    return id + "," + task + "," + isComplete;
    }
    public static ToDo fromString(String data) {
    String[] fields = data.split(",");
    int id = Integer.parseInt(fields[0]);
    String task = fields[1];
    boolean isComplete = Boolean.parseBoolean(fields[2]);
    return new ToDo(id, task, isComplete);
    }
    }

