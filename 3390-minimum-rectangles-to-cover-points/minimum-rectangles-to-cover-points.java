class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points,(a,b)->a[0]-b[0]);
        int start=points[0][0];
        int ans=1;
        for(int i=1;i<points.length;i++){
            if(points[i][0]-start<=w){

            }
            else{
                start=points[i][0];
                ans++;
            }
        }
        return ans;
    }
}