public class GeneralFeedbackHandler extends Handler{
    @Override
    public void handle(Message message) {
        if (message.getType() == Message.MessageType.GENERAL_FEEDBACK) {
            System.out.println("Processing general feedback " + message.getContent());
        } else if (nextHandler != null) {
            nextHandler.handle(message);
        }
    }
}
