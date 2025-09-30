class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ll=new ArrayList<>();
        int[] freq=new int[26];
        for(int i=0;i<p.length();i++){
            freq[p.charAt(i)-'a']++;
        }
        for(int i=0;i<=s.length()-p.length();i++){
            String t=s.substring(i,i+p.length());
            int[] freq1=new int[26];
            for(int j=0;j<t.length();j++){
                freq1[t.charAt(j)-'a']++;
            }
            if(ana(freq,freq1)){
                ll.add(i);
            }
        }
        return ll;
    }
    public boolean ana(int[] freq,int[] freq1){
        for(int i=0;i<26;i++){
            if(freq[i]>freq1[i]){
                return false;
            }
        }
        return true;
    }
}