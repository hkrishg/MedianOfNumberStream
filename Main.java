import java.util.*;

class Main {
  PriorityQueue<Integer> maxHeap;
  PriorityQueue<Integer> minHeap;

  Main() {
    maxHeap = new PriorityQueue<>((a, b) -> b - a);
    minHeap = new PriorityQueue<>((a, b) -> a - b);
  }

  public void insertSum(int num) {
    if (maxHeap.isEmpty() || maxHeap.peek() >= num)
      maxHeap.add(num);
    else
      minHeap.add(num);

    // either both the heaps are equal number of elements or max-heap will have one
    // more element than minHeap
    if (maxHeap.size() > minHeap.size() + 1)
      minHeap.add(maxHeap.poll());
    else if (maxHeap.size() < minHeap.size())
      maxHeap.add(minHeap.poll());
  }

  public double findMedian() {
    if (minHeap.size() == maxHeap.size())
      // if even take the average of middle 2 numbers
      return minHeap.peek() / 2.0 + maxHeap.peek() / 2.0;

    // as mahHeap has one extra element than minheap
    return maxHeap.peek();
  }

  public static void main(String[] args) {
    Main medianOfStream = new Main();
    medianOfStream.insertSum(3);
    medianOfStream.insertSum(1);
    medianOfStream.insertSum(5);
    medianOfStream.insertSum(4);
    System.out.println(medianOfStream.findMedian());
  }
}