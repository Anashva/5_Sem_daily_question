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
// exmple like x=00001111
// x+1=00010000
// then x | x+1= 11111  here highest setbit remain unchange while all others are changed
// so we count only 1 upto trailing bits,keeping highest set bit of traling remain same while other are removed