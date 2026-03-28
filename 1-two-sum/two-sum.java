class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int val=target-nums[i];
            if(mp.containsKey(val)){
                int k=mp.get(val);
                return new int[]{k,i};
            }
            mp.put(nums[i],i);
        }
        return new int[]{0,0};
    }
}