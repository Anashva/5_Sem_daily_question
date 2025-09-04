class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        // HashSet<String> st=new HashSet<>();
        // subs(binary,"",st);
        // return st.size();
        int one=0;
        int zero=0;
        int MOD = 1_000_000_007;
        boolean flag=false;
        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i)=='0'){
                zero=(zero+one)%MOD;
                flag=true;
            }
            else{
                one=(zero+one+1)%MOD;
            }
        }
        if(flag){
            return (zero+one+1)%MOD;
        }
        return (zero+one)%MOD;
    }
    // public void subs(String s,String ans,HashSet<String> st){
    //     if(s.length()==0){
    //         if(ans.length()>0){
    //             if(ans.equals("0") || ans.charAt(0)=='1'){
    //                 st.add(ans);
    //             }
    //         }
    //         return;
    //     }
    //     char ch=s.charAt(0);
    //     subs(s.substring(1),ans,st);
    //     subs(s.substring(1),ans+ch,st);
    // }

}