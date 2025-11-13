class Solution {
    public int maxOperations(String s) {
        int ans=0;
        int one=0;
        for(int i=0;i<s.length();){
            if(s.charAt(i)=='1'){
                one++;
                i++;
            }
            else{
                while(i<s.length() && s.charAt(i)=='0'){//aage tb tk jaenge jb tk one block nhi krega jaha 1 aa gya vha se block ho jaega 
                    i++;
                }
                ans+=one;
            }
        }
        return ans;
    }
}