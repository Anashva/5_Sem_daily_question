class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] left=new int[s.length()];
        int[] right=new int[s.length()];
        int[] pre=new int[s.length()];
        left[0]=s.charAt(0)=='|' ? 0:-1;
        pre[0]=s.charAt(0)=='*' ? 1:0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='|'){
                left[i]=i;
                pre[i]=pre[i-1];
            }
            else{
                left[i]=left[i-1];
                pre[i]=pre[i-1]+1;
            }
        }
        right[s.length() - 1] = s.charAt(s.length() - 1) == '|' ? s.length()- 1 : s.length();
        for(int i = s.length()- 2; i >= 0; i--){
            right[i] = s.charAt(i) == '|' ? i : right[i + 1];
        }
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int si=right[queries[i][0]];
            int ei=left[queries[i][1]];
            if(si<ei){
                ans[i]=pre[ei]-pre[si];
            }
        }
        return ans;
    }
}