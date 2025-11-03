class Solution {
    public String largestNumber(int[] cost, int target) {
        // List<String> ll=new ArrayList<>();
        // largest(cost,target,cost.length-1,"",ll);
        // if(ll.size()==0){
        //     return "0";
        // }
        // Collections.sort(ll);
        // String ans="0";
        // for(int i=0;i<ll.size();i++){
        //     String s=ll.get(i);
        //     if (s.length() > ans.length() || (s.length() == ans.length() && s.compareTo(ans) > 0)) {
        //         ans = s;
        //     }
        // }
        String[] dp = new String[target + 1];
        Arrays.fill(dp,null);
        String ans=TD(cost,target,dp);
        if(ans.equals("#")){
            return "0";
        }
        return ans;
    }
    public String TD(int[] arr,int target,String[]dp){
        if(target==0){
            return "";
        }
        if (target < 0){
            return "#";
        }
        if(dp[target]!=null){
            return dp[target];
        }
        String ans="#";
        for(int i=9;i>=1;i--){
            int n=arr[i-1];
            if(target>=n){
                String s=TD(arr,target-n,dp);
                if(!s.equals("#")){
                    String res=i+s;
                if(ans.equals("#") || res.length()>ans.length() || (ans.length() == res.length() && res.compareTo(ans) > 0)){
                    ans=res;
                }
                }
            }

        }
        return dp[target]=ans;
    }
    public void largest(int[] arr,int target,int idx,String ans,List<String> ll){
        if(target==0){
            ll.add(ans);
            return ;
        }
        if (target < 0 || idx < 0){
            return ;
        }
        if(target>=arr[idx]){
            largest(arr,target-arr[idx],idx,ans+(idx+1),ll);
        }
        largest(arr,target,idx-1,ans,ll);
    }
}