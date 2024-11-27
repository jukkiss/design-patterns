import java.util.Iterator;

class FibonacciSequence implements Sequence {
    private final int maxCount;

    public FibonacciSequence(int maxCount) {
        this.maxCount = maxCount;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(maxCount);
    }
}
