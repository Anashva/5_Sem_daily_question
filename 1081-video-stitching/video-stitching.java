class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips,(a,b)->Integer.compare(a[0],b[0]));
        int ans=0;
        int start=0;
        int end=0;
        int max=0;
        while(end<time){
            while(start<clips.length && clips[start][0]<=end){//overlap from previous 
                max=Math.max(max,clips[start][1]);//getting max until did not get overlap
                start++;
            }
            if(max==end){
                return -1;//end is stuck 
            }
            ans++;
            end=max;//start searching for clip from end 
        }

        return ans;
    }
}