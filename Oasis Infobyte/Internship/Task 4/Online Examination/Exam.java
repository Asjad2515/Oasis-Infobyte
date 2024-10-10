import java.io.FileWriter;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

public class Exam {
    private String username;

    public Exam(String username) {
        this.username = username;
    }

    public void selectExam() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available Exams :");
        System.out.println("1.Java");
        System.out.println("2. Python");
        System.out.println("Enter choice");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                startExam("java", username);
                break;
            case 2:
                startExam("python", username);
                break;
            default:
                System.out.println("invalid choice");
        }
    }

    public void startExam(String examName, String Username) {
        Question[] questions = getQuestions(examName);
        int score = 0;

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up!");
                System.exit(0);
            }
        }, 30 * 60 * 1000);
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i].getQuestion());
            System.out.println("Enter answer : ");
            String answer = sc.next();

            if (answer.equals(questions[i].getAnswer())) {
                score++;
            }
        }
        System.out.println("Exam completed.  Your score is : " + score);

        saveScore(username, examName, score);
    }

    private Question[] getQuestions(String examName) {
        File file = new File("resource/" + examName + "_question.txt");
        Scanner sc = new Scanner(file);

        Question[] question = new Question[10];
        int i = 0;
        while (sc.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            question[i] = new Question(parts[0], parts[1]);
            i++;
        }
        return question;
    }

    private void saveScore(String username, String examName, int score) {
        File file = new File("resources/scores.txt");
        FileWriter writer = new FileWriter(file, true);
        writer.write(username + "," + examName + "," + score + "\n");
        writer.close();
    }

}
