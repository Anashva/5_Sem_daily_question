class Solution {
    public int findSubstringInWraproundString(String s) {
        int[] count=new int[26];
        int c=1;
        for(int i=0;i<s.length();i++){
            if (i > 0 && ((s.charAt(i) - s.charAt(i - 1) == 1) || (s.charAt(i - 1) - s.charAt(i) == 25))) {
                c++;
            }
            else{
                c=1;
            }
            int id=s.charAt(i)-'a';
            count[id]=Math.max(c,count[id]);
        }
        int ans=0;
        for(int i:count){
            ans+=i;
        }
        return ans;
    }
}