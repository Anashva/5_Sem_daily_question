class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ll=new ArrayList<>();
        HashSet<String> st=new HashSet<>(wordDict);
        wb(s,st,ll,0,new StringBuilder());
        return ll;
    }
    public void wb(String s,HashSet<String> st,List<String> ll,int idx,StringBuilder sb){
        if(idx==s.length()){
            ll.add(sb.toString().trim());
            return;
        }
        for(int i=idx+1;i<=s.length();i++){
            String t=s.substring(idx,i);
            if(st.contains(t)){
                int len=sb.length();
                sb.append(t).append(" ");
                wb(s,st,ll,i,sb);
                sb.setLength(len);
            }
        }
    }
}