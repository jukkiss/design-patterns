import java.util.Iterator;

class FibonacciIterator implements Iterator<Integer> {
    private int prev1;
    private int prev2;
    private int count;
    private final int maxCount;

    public FibonacciIterator(int maxCount) {
        this.prev1 = 0;
        this.prev2 = 1;
        this.count = 0;
        this.maxCount = maxCount;
    }

    @Override
    public boolean hasNext() {
        return count < maxCount;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more Fibonacci numbers available");
        }
        int current;
        if (count == 0) {
            current = 1;
        } else if (count == 1) {
            current = 1;
        } else {
            current = prev1 + prev2;
        }
        prev1 = prev2;
        prev2 = current;
        count++;
        return current;
    }
}
