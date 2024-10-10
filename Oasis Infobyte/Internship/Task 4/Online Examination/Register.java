import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Register {
    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entre Username : ");
        String username = sc.next();

        System.out.print("Entre password : ");
        String password = sc.next();

        System.out.print("Entre name : ");
        String name = sc.next();

        System.out.print("Entre email : ");
        String email = sc.next();

        try {
            File file = new File("resources/users.txt");
            FileWriter writer = new FileWriter(file, true);
            writer.write(username + "," + password + "," + name + "," + email + "\n");
            writer.close();
            System.out.println("Registration successful");
        } catch (IOException e) {
            System.out.println("Error while registering user");
        }
    }

}
