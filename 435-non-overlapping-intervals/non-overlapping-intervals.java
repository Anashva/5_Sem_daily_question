class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int ans=1;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int end=intervals[0][1];
        // count number of non overlapping if current start >= end then it will be includeed otherwise overlap
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=end){
                ans++;
                end=intervals[i][1];
            }
        }
        return intervals.length-ans;
    }
}
// picking the interval that ends earliest leaves more room for others