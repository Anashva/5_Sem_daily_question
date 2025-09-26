class Solution {
    public int firstMissingPositive(int[] nums) {
       HashMap<Integer,Integer> mp=new HashMap<>();
       for(int i=0;i<nums.length;i++){
        mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
       }
       int c=1;
       for(int k:mp.keySet()){
        if(mp.containsKey(c)){
            c++;
        }
        else{
            return c;
        }
       }
       return c;
    }
}