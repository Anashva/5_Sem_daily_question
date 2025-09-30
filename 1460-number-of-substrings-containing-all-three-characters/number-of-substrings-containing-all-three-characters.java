class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character,Integer> mp=new HashMap<>();
        int start=0;
        int end=0;
        int ans=0;
        while(end<s.length()){
            mp.put(s.charAt(end),mp.getOrDefault(s.charAt(end),0)+1);
            while(mp.size()==3){
                ans+=s.length()-end;
                mp.put(s.charAt(start),mp.get(s.charAt(start))-1);
                if(mp.get(s.charAt(start))==0){
                    mp.remove(s.charAt(start));
                }
                start++;
            }
            end++;
        }
        return ans;
    }
}