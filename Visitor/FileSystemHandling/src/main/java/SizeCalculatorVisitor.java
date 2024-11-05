public class SizeCalculatorVisitor implements FileSystemVisitor {
    private double totalSize = 0;

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        // No action for directories as they don't directly contribute to the size.
    }

    public double getTotalSize() {
        return totalSize;
    }
}
