class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] arr=new int[2];
        int c=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i:nums){
            mp.put(i,mp.getOrDefault(i,0)+1);
            if(mp.get(i)>1){
                arr[c++]=i;
            }
        }
        return arr;
    }
}