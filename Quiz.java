import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private String topic;
    private List<Question> questions;

    public Quiz(String topic) {
        this.topic = topic;
        this.questions = new ArrayList<>();
    }

    public String getTopic() {
        return topic;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void takeQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }
            System.out.print("Your answer: ");
            int answer = scanner.nextInt() - 1;
            if (question.isCorrectAnswer(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is: " + options.get(question.getCorrectAnswerIndex() + 1));
            }
            System.out.println();  // Add gap after each question
        }
        System.out.println("You scored " + score + " out of " + questions.size());
        System.out.println();  // Add gap after displaying the score
    }
}
