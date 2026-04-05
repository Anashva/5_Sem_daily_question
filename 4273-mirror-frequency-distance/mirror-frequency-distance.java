class Solution {
    public int mirrorFrequency(String s) {
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            mp.put(c,mp.getOrDefault(c,0)+1);
        }
        int ans=0;
        HashSet<Character> st=new HashSet<>();
        for(char c:mp.keySet()){
            if(st.contains(c)){
                continue;
            }
            char m=c;
            if(Character.isDigit(c)){
                m=(char)('0'+('9'-c));
            }
            else{
                m=(char)('a'+('z'-c));
            }
            int freqc=mp.getOrDefault(c,0);
            int freqm=mp.getOrDefault(m,0);
            ans+=Math.abs(freqc-freqm);

            st.add(c);
            st.add(m);
        }
        return ans;
    }
}