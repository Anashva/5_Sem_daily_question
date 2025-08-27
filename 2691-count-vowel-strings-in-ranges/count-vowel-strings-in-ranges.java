class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int q = queries.length;
        int[] ans = new int[q];
        int[] pre=new int[words.length];
        if(Vowel(words[0])){
            pre[0]=1;
        }
        else{
            pre[0]=0;
        }
        for(int i=1;i<words.length;i++){
            if(Vowel(words[i])){
                pre[i]=pre[i-1]+1;
            }
            else{
                pre[i]=pre[i-1];
            }
        }
        for(int i=0;i<q;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            if (l == 0) {
                ans[i] = pre[r];
            } else {
                ans[i] = pre[r] - pre[l - 1];
            }
        }
        return ans;
    }
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public boolean Vowel(String s) {
        return isVowel(s.charAt(0)) && isVowel(s.charAt(s.length() - 1));
    }
}