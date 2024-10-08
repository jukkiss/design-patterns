public class Message {

    public enum MessageType {
        GENERAL_FEEDBACK,
        DEVELOPMENT_SUGGESTION,
        COMPENSATION_CLAIM,
        CONTACT_REQUEST
    }

    private MessageType type;
    private String content;
    private String email;

    public Message (MessageType type, String content, String email) {
        this.type = type;
        this.content = content;
        this.email = email;
    }

    public MessageType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public String getEmail() {
        return email;
    }
}
