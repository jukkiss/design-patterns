public class CompensationClaimHandler extends Handler {
    @Override
    public void handle(Message message) {
        if (message.getType() == Message.MessageType.COMPENSATION_CLAIM) {
            System.out.println("Processing compensation claim: " + message.getContent());
        } else if (nextHandler != null) {
            nextHandler.handle(message);
        }
    }
}
