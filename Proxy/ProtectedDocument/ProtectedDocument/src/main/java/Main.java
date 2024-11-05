public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        User alice = new User("maija");
        User bob = new User("matti");

        DocumentInterface publicDoc = new Document("doc1", "2023-01-01", "This is a public document.");
        library.addDocument(publicDoc);

        library.addProtectedDocument("doc2", "2023-02-01", "This is a protected document.", "alice");

        try {
            System.out.println("Maija accessing doc1: " + library.getDocument("doc1").getContent(alice));
            System.out.println("Matti accessing doc1: " + library.getDocument("doc1").getContent(bob));
            System.out.println("Maija accessing doc2: " + library.getDocument("doc2").getContent(alice));
            System.out.println("Matti accessing doc2: " + library.getDocument("doc2").getContent(bob));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}
