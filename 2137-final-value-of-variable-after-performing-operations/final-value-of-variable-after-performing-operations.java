class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans=0;
        for(String s:operations){
            if(s.startsWith("--") || s.endsWith("--")){
                ans-=1;
            }
            else if(s.startsWith("++") || s.endsWith("++")){
                ans+=1;
            }
        }
        return ans;
    }
}