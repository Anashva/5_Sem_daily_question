class Solution {
    public int countTriplets(int[] nums) {
        int ans=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                int ele=nums[i] & nums[j];
                mp.put(ele,mp.getOrDefault(ele,0)+1);
            }
        }
        for(int i:nums){
            for(int k:mp.keySet()){
                if((i & k)==0){
                    ans+=mp.get(k);
                }
            }
        }
        return ans;
    }
}