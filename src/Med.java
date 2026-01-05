import java.util.PriorityQueue;

public class Med {

    public static void main(String[] args){
        MedianFinder md = new MedianFinder();
        md.addNum(6);
        md.addNum(10);
        md.addNum(2);
        md.addNum(6);
        md.addNum(5);
        md.addNum(0);
        md.addNum(6);
        md.addNum(3);
        md.addNum(1);
        md.addNum(0);
        md.addNum(0);
    }
}
class MedianFinder {

    int total;
    PriorityQueue<Integer> firstHalf;
    PriorityQueue<Integer> secondHalf;

    public MedianFinder() {
        total = 0;
        firstHalf = new PriorityQueue<>((a, b) -> b-a);
        secondHalf = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (total == 0 || num > secondHalf.peek()){
            if (total%2 == 1){
                int poll = secondHalf.poll();
                int tmp = num;
                num = Math.max(poll, tmp);
                poll = Math.min(poll, tmp);
                firstHalf.add(poll);
            }
            secondHalf.add(num);
        }
        else{
            if (total>1 && total%2 == 0){
                int poll = firstHalf.poll();
                int tmp = num;
                num = Math.min(poll, tmp);
                poll = Math.max(poll, tmp);
                secondHalf.add(poll);
            }
            firstHalf.add(num);
        }
        total++;
    }

    public double findMedian() {
        if (total%2 == 0) return ((double)firstHalf.peek()+(double)secondHalf.peek())/2;
        return secondHalf.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */