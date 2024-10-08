public class Main {
    public static void main(String[] args) {
        Handler compensationHandler = new CompensationClaimHandler();
        Handler contactHandler = new ContactRequestHandler();
        Handler suggestionHandler = new DevelopmentSuggestionHandler();
        Handler feedbackHandler = new GeneralFeedbackHandler();

        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(suggestionHandler);
        suggestionHandler.setNextHandler(feedbackHandler);

        Message message1 = new Message(Message.MessageType.COMPENSATION_CLAIM, "I want a refund.", "customer1@example.com");
        Message message2 = new Message(Message.MessageType.CONTACT_REQUEST, "Please call me back.", "customer2@example.com");
        Message message3 = new Message(Message.MessageType.DEVELOPMENT_SUGGESTION, "I have a feature idea.", "customer3@example.com");
        Message message4 = new Message(Message.MessageType.GENERAL_FEEDBACK, "Great service!", "customer4@example.com");

        compensationHandler.handle(message1);
        compensationHandler.handle(message2);
        compensationHandler.handle(message3);
        compensationHandler.handle(message4);
    }
}
