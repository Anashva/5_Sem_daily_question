class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(arr[0],1);
        int ans=1;
        for(int i=1;i<arr.length;i++){
            int val=arr[i]-difference;
            if(mp.containsKey(val)){
                mp.put(arr[i],mp.get(val)+1);
            }
            else{
                mp.put(arr[i],1);
            }
        }
        for(int k:mp.keySet()){
            ans=Math.max(ans,mp.get(k));
        }
        return ans;
    }
}