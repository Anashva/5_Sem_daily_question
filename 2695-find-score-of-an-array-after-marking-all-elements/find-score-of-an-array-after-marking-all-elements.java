class Solution {
    public long findScore(int[] nums) {
        boolean[] visit=new boolean[nums.length];
        int[][] marked=new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            marked[i][0]=nums[i];
            marked[i][1]=i;
        }
        long ans=0;
        Arrays.sort(marked,(a,b)->Integer.compare(a[0], b[0]));
        for(int i=0;i<nums.length;i++){
            if(!visit[marked[i][1]]){
                ans+=marked[i][0];
                visit[marked[i][1]]=true;
                if(marked[i][1]-1>=0){
                    visit[marked[i][1]-1]=true;
                }
                if(marked[i][1]+1<nums.length){
                    visit[marked[i][1]+1]=true;
                }
            }
        }
        return ans;
    }
}