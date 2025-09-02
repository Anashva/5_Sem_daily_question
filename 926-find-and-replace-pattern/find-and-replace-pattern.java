class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            int[] freq1=new int[26];
            int[] freq2=new int[26];
            String s=words[i];
            boolean flag=true;
            for(int j=0;j<words[i].length();j++){
                if(freq1[s.charAt(j)-'a']!=freq2[pattern.charAt(j)-'a']){
                    flag=false;
                    break;
                }
                else{
                    freq1[s.charAt(j)-'a']=freq2[pattern.charAt(j)-'a']=j+1;
                }
            }if(flag){
                ans.add(s);
            }
        }
        return ans;
    }
}