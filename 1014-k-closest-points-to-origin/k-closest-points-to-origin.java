class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans=new int[k][2];
        PriorityQueue<double[]> pq=new PriorityQueue<>(Comparator.comparingDouble(a -> a[2]));
        for(int i=0;i<points.length;i++){
            double sqrt=Math.sqrt(points[i][0]*points[i][0]+points[i][1]*points[i][1]);
            double n1=points[i][0];
            double n2=points[i][1];
            pq.add(new double[]{n1,n2,sqrt});      
        }
        int i=0;
        while(k-->0){
            double[] arr=pq.poll();
            int n1=(int)arr[0];
            int n2=(int)arr[1];
            ans[i][0]=n1;
            ans[i][1]=n2;
            i++;
        }
        return ans;
    }
}