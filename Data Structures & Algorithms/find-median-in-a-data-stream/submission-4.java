class MedianFinder {
    private Queue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    private Queue<Integer> large = new PriorityQueue<>();

    // time: O(log N);
    public void addNum(int num) {
        small.offer(num);
        if (!large.isEmpty() && small.peek() > large.peek()) {
            large.offer(small.poll());
        }
        if (small.size() - large.size() > 1) {
            large.offer(small.poll());
        }
        if (large.size() - small.size() > 1) {
            small.offer(large.poll());
        }
    }

    // time: O(1);
    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        } else {
            return (small.peek() + large.peek()) / 2.0;
        }
    }
}
