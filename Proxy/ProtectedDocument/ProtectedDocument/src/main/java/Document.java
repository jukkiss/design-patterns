public class Document implements DocumentInterface {
    private String identifier;
    private String creationDate;
    private String content;

    public Document(String identifier, String creationDate, String content) {
        this.identifier = identifier;
        this.creationDate = creationDate;
        this.content = content;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getContent(User user) {
        return content;
    }
}
