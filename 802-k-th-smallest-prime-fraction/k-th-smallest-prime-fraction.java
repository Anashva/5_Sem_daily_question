class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(a[0], b[0])
        );
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                double ele=(double)arr[i]/arr[j];
                pq.add(new double[]{ele,(double)arr[i],(double)arr[j]});
            }
        }
        while(k-->1){
            pq.poll();
        }
        double[] top = pq.peek();
        return new int[]{(int) top[1], (int) top[2]};
    }
}