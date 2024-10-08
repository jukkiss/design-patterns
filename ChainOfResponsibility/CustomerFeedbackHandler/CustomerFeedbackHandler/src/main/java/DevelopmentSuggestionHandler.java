public class DevelopmentSuggestionHandler extends Handler {
    @Override
    public void handle(Message message) {
        if (message.getType() == Message.MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("Processing development suggestion: " + message.getContent());
        } else if (nextHandler != null) {
            nextHandler.handle(message);
        }
    }
}
