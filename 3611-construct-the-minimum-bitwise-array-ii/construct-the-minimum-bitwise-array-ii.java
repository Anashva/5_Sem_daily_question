class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n=nums.size();
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            int num=nums.get(i);
            if((num & 1)==0){
                ans[i]=-1;
            }
            else{
                int setbit=0;
                while((num & (1<<setbit))!=0){
                    // x^=(1<<setbit);
                    setbit++;
                }
                ans[i] = num-(1 <<(setbit-1));//we will remove all the trailing setbit except highest one
            }
        }
        return ans;
    }
}