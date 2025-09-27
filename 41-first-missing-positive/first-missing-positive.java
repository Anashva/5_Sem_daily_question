class Solution {
    public int firstMissingPositive(int[] nums) {
      HashSet<Integer> mp=new HashSet<>();
      for(int i:nums){
        mp.add(i);
      }
       int c=1;
       for(int k:mp){
        if(mp.contains(c)){
            c++;
        }
        else{
            return c;
        }
       }
       return c;
    }
}