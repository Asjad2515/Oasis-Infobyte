import java.util.*;

public class gussing_num {
    @SuppressWarnings("unused")
    public static void main(String[] argts) {

        Random rand = new Random();

        int numberToGuess = rand.nextInt(100) + 1;

        Scanner sc = new Scanner(System.in);

        int attempts = 0;

        System.out.print("Type your name ");
        String userName = sc.nextLine();

        System.out.println("welcome " + userName + " to the number gussing game!");

        System.out.println("Think a number between 1 to 100");

        System.out.print("Guess  a  Number : ");

        while (true) {
            attempts++;
            int userGuess = sc.nextInt();

            if (userGuess < 1 || userGuess > 100) {
                System.out.println("Invalid number!  please insert a number between 1 to 100");
            } else if (userGuess < numberToGuess) {
                System.out.print("Higher number please!");
            } else if (userGuess > numberToGuess) {
                System.out.print("Lower number please!");
            } else {
                System.out.println("Congratulation! You guessed it in " + attempts + " Attempts");
                break;
            }
        }

    }

}
