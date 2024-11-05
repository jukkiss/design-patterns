import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private String searchPattern;
    private List<File> foundFiles;

    public SearchVisitor(String searchPattern) {
        this.searchPattern = searchPattern;
        this.foundFiles = new ArrayList<>();
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(searchPattern)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        // No action required for directory search.
    }

    public List<File> getFoundFiles() {
        return foundFiles;
    }
}
