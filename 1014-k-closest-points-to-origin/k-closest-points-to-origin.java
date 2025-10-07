class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> pq=new PriorityQueue<>(Comparator.comparingDouble(a->a[2]));
        int[][] ans=new int[k][2];
        for(int i=0;i<points.length;i++){
            double srt=Math.sqrt(points[i][0]*points[i][0] + points[i][1]*points[i][1]);
            double x=points[i][0];
            double y=points[i][1];
            pq.add(new double[]{x,y,srt});
        }
        int i=0;
        while(k-->0){
            double[] arr=pq.poll();
            ans[i][0]=(int)arr[0];
            ans[i++][1]=(int)arr[1];
        }
        return ans;
    }
}