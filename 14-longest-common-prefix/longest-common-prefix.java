class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }
        int len=200;
        for(String s:strs){
            len=Math.min(s.length(),len);
        }
        String ans="";
        String s=strs[0];
        for(int i=0;i<len;i++){
            char ch=s.charAt(i);
            int c=-1;
            for(int j=1;j<strs.length;j++){
                String t=strs[j];
                if(ch!=t.charAt(i)){
                    c=-1;
                    break;
                }
                else{
                    c=i;
                }
            }
            if(c==-1){
                break;
            }
            if(c!=-1){
                ans=s.substring(0,i+1);
            }
        }
        return ans;
    }
}