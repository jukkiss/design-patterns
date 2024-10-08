public class ContactRequestHandler extends Handler {
    @Override
    public void handle(Message message) {
        if (message.getType() == Message.MessageType.CONTACT_REQUEST) {
            System.out.println("Processing contact request: " + message.getContent());
        } else if (nextHandler != null) {
            nextHandler.handle(message);
        }
    }
}
