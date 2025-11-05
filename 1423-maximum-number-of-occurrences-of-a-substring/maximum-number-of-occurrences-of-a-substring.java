class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int ans=0;
        HashMap<String,Integer> mp=new HashMap<>();
        for(int i=0;i<=s.length()- minSize;i++){
            String t=s.substring(i,i+minSize);
            if(check(t,maxLetters)){
                mp.put(t,mp.getOrDefault(t,0)+1);
                ans=Math.max(ans,mp.get(t));
            }
        }
        return ans;
    }
    public boolean check(String t,int k){
        HashSet<Character> st=new HashSet<>();
        for(int i=0;i<t.length();i++){
            st.add(t.charAt(i));
        }
        return st.size()<=k;
    }
    
}