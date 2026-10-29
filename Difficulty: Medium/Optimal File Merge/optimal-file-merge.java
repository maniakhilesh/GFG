class Solution {
    public int minComputation(int[] files) {
        // code here
        PriorityQueue<Integer> queue = new PriorityQueue<>();
                for(int file:files) {
                    queue.offer(file);
                }

                int sum = 0;
                while(queue.size()>1) {
                    int merge = 0;
                    merge+=queue.poll();
                    merge+=queue.poll();
                    sum += merge;
                    queue.offer(merge);
                }
                return sum;
    }
}