import java.io.File;

public class createFile {
    public static void main(String[] args) {
File myObj = new File("filename.txt");
    if (myObj.createNewFile()) {
        System.out.println("file created" + myObj.getName());

    } else {
        System.out.println("File already exist");
    }
    }
   
    
}
