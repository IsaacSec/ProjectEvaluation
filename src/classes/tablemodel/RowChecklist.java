package classes.tablemodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Node;
import javafx.scene.control.Control;

public class RowChecklist <T extends Node>{
    private SimpleStringProperty topic;
    private SimpleStringProperty question;
    public T answer;

    public RowChecklist (String topic,
                         String question,
                         T answer) {
        this.topic = new SimpleStringProperty(topic);
        this.question = new SimpleStringProperty(question);
        this.answer = answer;
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

    public T getAnswer() {
        return answer;
    }

    public void setAnswer(T answer) {
        this.answer = answer;
    }
}
