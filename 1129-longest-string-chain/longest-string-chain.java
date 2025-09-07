class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        HashMap<String,Integer> mp=new HashMap<>();
        int ans=1;
        for(int i=0;i<words.length;i++){
            String s=words[i];
            mp.put(s,1);
            for(int j=0;j<s.length();j++){
                String pre=s.substring(0,j)+s.substring(j+1);
                if(mp.containsKey(pre)){
                    mp.put(s,Math.max(mp.get(s), mp.get(pre) + 1));
                }
            }
            ans=Math.max(ans,mp.get(s));
        }
        return ans;
    }
}