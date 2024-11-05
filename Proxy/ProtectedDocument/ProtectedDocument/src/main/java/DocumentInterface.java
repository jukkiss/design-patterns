public interface DocumentInterface {
    String getIdentifier();
    String getCreationDate();
    String getContent(User user) throws AccessDeniedException;
}
