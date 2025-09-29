class Solution {
    public String getSmallestString(String s, int k) {
        if(k==0){
            return s;
        }
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            for(char ch='a';ch<='z';ch++){
                int dis=dis(s.charAt(i),ch);
                if(dis<=k){
                    sb.setCharAt(i,ch);
                    k-=dis;
                    break;
                }
            }
        }
        return sb.toString();
    }
    public int dis(char s,char ch){
        int k=Math.abs(s-ch);
        return Math.min(k,26-k);
    }
}