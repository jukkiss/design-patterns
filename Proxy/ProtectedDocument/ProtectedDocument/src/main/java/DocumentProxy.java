public class DocumentProxy implements DocumentInterface {
    private Document realDocument;
    private AccessControlService accessControlService;

    public DocumentProxy(Document realDocument) {
        this.realDocument = realDocument;
        this.accessControlService = AccessControlService.getInstance();
    }

    public String getIdentifier() {
        return realDocument.getIdentifier();
    }

    public String getCreationDate() {
        return realDocument.getCreationDate();
    }

    public String getContent(User user) throws AccessDeniedException {
        if (accessControlService.isAllowed(realDocument.getIdentifier(), user.getUsername())) {
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException("Access denied for user " + user.getUsername());
        }
    }
}
