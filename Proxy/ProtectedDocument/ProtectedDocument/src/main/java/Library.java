import java.util.HashMap;

public class Library {
    private HashMap<String, DocumentInterface> documents = new HashMap<>();

    public void addDocument(DocumentInterface document) {
        documents.put(document.getIdentifier(), document);
    }

    public DocumentInterface getDocument(String identifier) {
        return documents.get(identifier);
    }

    public void addProtectedDocument(String identifier, String creationDate, String content, String... allowedUsers) {
        Document realDocument = new Document(identifier, creationDate, content);
        DocumentProxy proxy = new DocumentProxy(realDocument);
        for (String user : allowedUsers) {
            AccessControlService.getInstance().grantAccess(identifier, user);
        }
        addDocument(proxy);
    }
}
