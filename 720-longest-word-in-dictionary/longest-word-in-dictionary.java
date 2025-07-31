class Solution {
    public String longestWord(String[] words) {
        HashSet<String> st=new HashSet<>();
        Arrays.sort(words,(a,b)->{
            if(a.equals(b)){
                return 0;
            }
            if(a.compareTo(b)!=0){
                return a.compareTo(b);
            }
            return Integer.compare(b.length(),a.length());
        });
        String ans="";
        for(String s:words){
            if(s.length()==1 || st.contains(s.substring(0,s.length()-1))){
                st.add(s);
                if(s.length()>ans.length()){
                    ans=s;
                }
            }
        }
        return ans;
    }
}