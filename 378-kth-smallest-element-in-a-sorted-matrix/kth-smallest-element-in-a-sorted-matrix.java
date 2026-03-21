class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int s=matrix.length*matrix[0].length;
        int[] nums=new int[s];
        int t=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                nums[t]=matrix[i][j];
                t++;
            }
        }
        Arrays.sort(nums);
        return nums[k-1];

    }
}