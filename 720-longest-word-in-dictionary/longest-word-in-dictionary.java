class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words,(a,b)->{
            if(a.compareTo(b)!=0){
                return a.compareTo(b);
            }
            return Integer.compare(a.length(),b.length());
        });
        String ans="";
        HashSet<String> st=new HashSet<>();
        for(String s:words){
            if(s.length()==1){
                st.add(s);
                if(s.length()>ans.length()){
                    ans=s;
                }
            }
            if(st.contains(s.substring(0,s.length()-1))){
                st.add(s);
                if(s.length()>ans.length()){
                    ans=s;
                }
            }
        }
        return ans;
    }
}