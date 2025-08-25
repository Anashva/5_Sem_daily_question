class Solution {
    public int maxRepOpt1(String s) {
        int ans=0;
        for(char ch='a';ch<='z';ch++){
            ans=Math.max(ans,repeat(s,ch));
        }
        return ans;
    }
    public int repeat(String s,char ch){
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==ch){
                freq[ch-'a']++;
            }
        }
        if(freq[ch-'a']==0){
            return 0;
        }
        int ans=0;
        for(int i=0;i<s.length();i++){
            int count=0;
            int c=0;
            for(int j=i;j<s.length();j++){
                if(s.charAt(j)==ch){
                    c++;
                }
                else if(count==0){
                    count++;
                }
                else{
                    break;
                }
            }
            if(c<freq[ch-'a']){
                c++;
            }
            ans=Math.max(ans,c);
        }
        return ans;
    }
}
