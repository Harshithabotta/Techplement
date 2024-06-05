import java.util.ArrayList;
import java.util.List;

public class QuizManager {
    private List<Quiz> quizzes;

    public QuizManager() {
        this.quizzes = new ArrayList<>();
    }

    public void createQuiz(String topic) {
        quizzes.add(new Quiz(topic));
    }

    public void addQuestionToQuiz(String topic, Question question) {
        for (Quiz quiz : quizzes) {
            if (quiz.getTopic().equalsIgnoreCase(topic)) {
                quiz.addQuestion(question);
				System.out.println();
                return;
            }
        }
        System.out.println("Quiz with topic " + topic + " not found.");
		System.out.println();
    }

    public void takeQuiz(String topic) {
        for (Quiz quiz : quizzes) {
            if (quiz.getTopic().equalsIgnoreCase(topic)) {
                quiz.takeQuiz();
                return;
            }
        }
        System.out.println("Quiz with topic " + topic + " not found.");
		System.out.println();
    }

    public List<String> getAvailableTopics() {
        List<String> topics = new ArrayList<>();
        for (Quiz quiz : quizzes) {
            topics.add(quiz.getTopic());
        }
        return topics;
    }
}
