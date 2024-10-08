import java.util.Random;

public class PerformanceTest {
    public static void main(String[] args) {
        SortingContext context = new SortingContext();

        int[] smallArray = generateRandomArray(30);
        int[] largeArray = generateRandomArray(100000);

        context.setStrategy(new BubbleSort());
        measurePerformance(context, smallArray.clone(), "Bubble Sort on Small Array");
        measurePerformance(context, largeArray.clone(), "Bubble Sort on Large Array");

        context.setStrategy(new QuickSort());
        measurePerformance(context, smallArray.clone(), "Quick Sort on Small Array");
        measurePerformance(context, largeArray.clone(), "Quick Sort on Large Array");

        context.setStrategy(new MergeSort());
        measurePerformance(context, smallArray.clone(), "Merge Sort on Small Array");
        measurePerformance(context, largeArray.clone(), "Merge Sort on Large Array");
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);
        }
        return array;
    }

    private static void measurePerformance(SortingContext context, int[] array, String testName) {
        long startTime = System.nanoTime();
        context.executeStrategy(array);
        long endTime = System.nanoTime();
        System.out.println(testName + " took " + (endTime - startTime) / 1000000.0 + " ms");
    }
}
