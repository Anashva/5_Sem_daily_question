class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] ans=new int[k];
        int[][] arr=new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        Arrays.sort(arr,(a,b)->Integer.compare(b[0], a[0]));
        int[][] cp=new int[k][2];
        for(int i=0;i<k;i++){
            cp[i][0]=arr[i][0];
            cp[i][1]=arr[i][1];
        }
        Arrays.sort(cp,(a,b)->Integer.compare(a[1], b[1]));
        for(int i=0;i<k;i++){
            ans[i]=cp[i][0];
        }
        return ans;
    }
}