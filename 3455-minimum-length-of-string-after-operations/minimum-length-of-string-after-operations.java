class Solution {
    public int minimumLength(String s) {
        if(s.length()<3){
            return s.length();
        }
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
            if(mp.get(s.charAt(i))>2){
                mp.put(s.charAt(i),mp.get(s.charAt(i))-2);
            }
        }
        int ans=0;
        for(int k:mp.values()){
            ans+=k;
        }
        return ans;
    }
}