public class FileSystemExample {
    public static void main(String[] args) {
        File file1 = new File("document.txt", 2.0);
        File file2 = new File("image.png", 5.5);
        File file3 = new File("notes.txt", 1.2);

        Directory root = new Directory("root");
        Directory folder1 = new Directory("folder1");
        Directory folder2 = new Directory("folder2");

        folder1.addElement(file1);
        folder1.addElement(file2);
        folder2.addElement(file3);

        root.addElement(folder1);
        root.addElement(folder2);

        SizeCalculatorVisitor sizeCalculator = new SizeCalculatorVisitor();
        root.accept(sizeCalculator);
        System.out.println("Total size: " + sizeCalculator.getTotalSize() + " MB");

        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        root.accept(searchVisitor);
        System.out.println("Found .txt files:");
        for (File file : searchVisitor.getFoundFiles()) {
            System.out.println(" - " + file.getName());
        }
    }
}
