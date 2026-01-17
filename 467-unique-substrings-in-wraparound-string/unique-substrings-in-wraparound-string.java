class Solution {
    public int findSubstringInWraproundString(String s) {
        int[] ch=new int[26];
        int c=1;
        for(int i=0;i<s.length();i++){
            if(i>0 && (s.charAt(i)-s.charAt(i-1)==1 || s.charAt(i-1)-s.charAt(i)==25)){
                c++;
            }
            else{
                c=1;
            }
            int idx=s.charAt(i)-'a';// valid substring upto given end
            ch[idx]=Math.max(c,ch[idx]);
        }
        int ans=0;
        for(int k:ch){
            ans+=k;
        }
        return ans;
    }
}