class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean flag=false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                flag=true;
            }
            if(nums[i]<=0 || nums[i]>nums.length){
                nums[i]=1;
            }
        }
        if(!flag){
            return 1;
        }
        for(int i=0;i<nums.length;i++){
            int id=Math.abs(nums[i])-1;
           if(nums[id]>0){
            nums[id]=-nums[id];
           }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                return i+1;
            }
        }
        return nums.length+1;






    //   HashSet<Integer> mp=new HashSet<>();
    //   for(int i:nums){
    //     mp.add(i);
    //   }
    //    int c=1;
    //    for(int k:mp){
    //     if(mp.contains(c)){
    //         c++;
    //     }
    //     else{
    //         return c;
    //     }
    //    }
    //    return c;
    }
}