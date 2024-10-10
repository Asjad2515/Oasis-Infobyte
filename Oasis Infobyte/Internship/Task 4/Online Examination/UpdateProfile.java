import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateProfile {
    public void updateProfile(String username) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entre new name");
        String name = sc.next();
        System.out.print("Entre new email");
        String email = sc.next();
        System.out.print("Entre new password");
        String password = sc.next();

        try {
            File file = new File("resources/users.txt");
            FileWriter writer = new FileWriter(file);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] credentials = line.split(",");
                if (credentials[0].equals(username)) {
                    writer.write(username + "," + password + "," + name + "," + email + "\n");
                } else {
                    writer.write(line + "\n");
                }
            }
            writer.close();
            System.out.println("profile updated Successfully");
        } catch (IOException e) {
            System.out.println("Error updating profile!");
        }
    }

}
