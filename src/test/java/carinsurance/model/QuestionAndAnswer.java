package carinsurance.model;

public record QuestionAndAnswer(String question, String answer) {

    @Override
    public String toString() {
        return question + " = " + answer + "'";
    }
}
