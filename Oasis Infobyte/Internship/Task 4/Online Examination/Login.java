import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Login {
    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entre username : ");
        String username = sc.next();

        System.out.print("Entre Password");
        String password = sc.next();

        try {
            File file = new File("resources/users.txt");
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] credentials = line.split(",");
                if (credentials[0].equals(username) && credentials[1].equals(password)) {
                    System.out.println("Login successful");

                    Exam exam = new Exam(username);
                    exam.selectExam();
                    return;
                }
            }
            System.out.println("Invalid username or password");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

}
