class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((a, b) -> {
            if (a.length() != b.length()){
                return b.length() - a.length();
                }
            return a.compareTo(b);
            });
            String ans="";
        for(String t:dictionary){
            int i=0;
            int j=0;
            while(i<t.length() && j<s.length()){
                if(s.charAt(j)==t.charAt(i)){
                    i++;
                    j++;
                }
                else{
                    j++;
                }
            }
            if(i==t.length()){
                if(ans.length()<t.length()){
                    ans=t;
                }
            }
        }
        if(ans==""){
            return "";
        }
        return ans;

    }
}