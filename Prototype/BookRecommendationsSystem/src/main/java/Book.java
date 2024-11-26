public class Book implements Cloneable {
    private String title;
    private String author;
    private String genre;
    private int publicationYear;


    public Book(String title, String author, String genre, int publicationYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Override
    protected Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Shouldn't happen because we implement Cloneable
        }
    }

    @Override
    public String toString() {
        return "'" + title + "' by " + author + " (Genre: " + genre + ", Year: " + publicationYear + ")";
    }
}
