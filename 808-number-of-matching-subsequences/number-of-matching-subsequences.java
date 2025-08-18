class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<String,Integer> mp=new HashMap<>();
        for(String st:words){
            mp.put(st,mp.getOrDefault(st,0)+1);
        }
        int ans=0;
        for(String ch:mp.keySet()){
            int i=0;
            int j=0;
            while(i<ch.length() && j<s.length()){
                if(s.charAt(j)==ch.charAt(i)){
                    i++;
                    j++;
                }
                else{
                    j++;
                }
            }
            if(i==ch.length()){
                ans+=mp.get(ch);
            }
        }
        return ans;
    }
}