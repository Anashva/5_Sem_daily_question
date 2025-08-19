class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[] answer=new int[2];
        Arrays.fill(answer,-1);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(Math.abs(i-j)>=indexDifference && Math.abs(nums[i]-nums[j])>=valueDifference){
                    answer[0]=i;
                    answer[1]=j;
                }
            }
        }
        return answer;
    }
}