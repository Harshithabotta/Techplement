import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuizGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuizManager quizManager = new QuizManager();

        while (true) {
            System.out.println("1. Create Quiz");
            System.out.println("2. Add Question to Quiz");
            System.out.println("3. Take Quiz");
            System.out.println("4. List Available Topics");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline
			System.out.println();

            switch (option) {
                case 1:
                    System.out.print("Enter quiz topic: ");
                    String topic = scanner.nextLine();
                    quizManager.createQuiz(topic);
					System.out.println();
                    break;

                case 2:
                    System.out.print("Enter quiz topic: ");
                    topic = scanner.nextLine();
                    System.out.print("Enter question text: ");
                    String questionText = scanner.nextLine();
                    System.out.println("Enter options (comma separated): ");
                    String[] optionsArray = scanner.nextLine().split(",");
                    List<String> options = Arrays.asList(optionsArray);
                    System.out.print("Enter index of correct answer (starting from 1): ");
                    int correctAnswerIndex = scanner.nextInt() - 1;
                    scanner.nextLine();  // Consume newline
                    Question question = new Question(questionText, options, correctAnswerIndex);
                    quizManager.addQuestionToQuiz(topic, question);
					System.out.println();
                    break;

                case 3:
                    System.out.print("Enter quiz topic: ");
                    topic = scanner.nextLine();
                    quizManager.takeQuiz(topic);
					System.out.println();
                    break;

                case 4:
                    List<String> topics = quizManager.getAvailableTopics();
                    System.out.println("Available topics: " + String.join(", ", topics));
					System.out.println();
                    break;

                case 5:
                    System.out.println("Exiting...");
					System.out.println();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
