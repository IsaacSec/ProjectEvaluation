package classes.tablemodel;

import javafx.beans.property.SimpleStringProperty;

public class TableChecklist {
    private SimpleStringProperty topic;
    private SimpleStringProperty question;
    private SimpleStringProperty answer;

    public TableChecklist(String topic,
                          String question,
                          String answer) {
        this.topic = new SimpleStringProperty(topic);
        this.question = new SimpleStringProperty(question);
        this.answer = new SimpleStringProperty(answer);
    }

    public String getTopic() {
        return topic.get();
    }

    public SimpleStringProperty topicProperty() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic.set(topic);
    }

    public String getQuestion() {
        return question.get();
    }

    public SimpleStringProperty questionProperty() {
        return question;
    }

    public void setQuestion(String question) {
        this.question.set(question);
    }

    public String getAnswer() {
        return answer.get();
    }

    public SimpleStringProperty answerProperty() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer.set(answer);
    }
}
