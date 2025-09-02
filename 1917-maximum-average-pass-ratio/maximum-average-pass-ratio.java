class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq=new PriorityQueue<>((a, b) -> Double.compare(b[2], a[2]));
        for(int[] arr:classes){
            double val=(double)((arr[0]+1.0)/(arr[1]+1.0))-(double)(arr[0]*1.0/arr[1]);
            pq.add(new double[]{arr[0],arr[1],val});
        }
        while(extraStudents-->0){
            double[] arr=pq.poll();
            arr[0]+=1;
            arr[1]+=1;
            arr[2]=(double)((arr[0]+1.0)/(arr[1]+1.0))-(double)(arr[0]*1.0/arr[1]);
            pq.add(arr);
        }
        int n=classes.length;
        double total=0;
        while(!pq.isEmpty()){
            double[] cls = pq.poll();
            total += cls[0]/cls[1];
        }
        return total/n;
    }
}