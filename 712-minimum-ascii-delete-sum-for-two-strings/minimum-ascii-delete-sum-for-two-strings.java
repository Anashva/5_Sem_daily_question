class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        // return deletesum(s1,s2,0,0);
        int[][] dp=new int[s1.length()][s2.length()];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return memo(s1,s2,0,0,dp);
    }
    // public int deletesum(String s1,String s2,int i,int j){
    //     if(i==s1.length()){
    //         int sum=0;
    //         for(int k=j;k<s2.length();k++){
    //             sum+=s2.charAt(k);
    //         }
    //         return sum;
    //     }
    //     if(j==s2.length()){
    //         int sum=0;
    //         for(int k=i;k<s1.length();k++){
    //             sum+=s1.charAt(k);
    //         }
    //         return sum;
    //     }

    //     int ans=0;
    //     if(s1.charAt(i)==s2.charAt(j)){
    //         ans=deletesum(s1,s2,i+1,j+1);
    //     }
    //     else{
    //         int l=s1.charAt(i)+deletesum(s1,s2,i+1,j);
    //         int r=s2.charAt(j)+deletesum(s1,s2,i,j+1);
    //         ans+=Math.min(l,r);
    //     }
    //     return ans;
    // }

    public int memo(String s1,String s2,int i,int j,int[][] dp){
        if(i==s1.length()){
            int sum=0;
            for(int k=j;k<s2.length();k++){
                sum+=s2.charAt(k);
            }
            return sum;
        }
        if(j==s2.length()){
            int sum=0;
            for(int k=i;k<s1.length();k++){
                sum+=s1.charAt(k);
            }
            return sum;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(s1.charAt(i)==s2.charAt(j)){
            ans=memo(s1,s2,i+1,j+1,dp);
        }
        else{
            int l=s1.charAt(i)+memo(s1,s2,i+1,j,dp);
            int r=s2.charAt(j)+memo(s1,s2,i,j+1,dp);
            ans+=Math.min(l,r);
        }
        return dp[i][j]=ans;
    }
}