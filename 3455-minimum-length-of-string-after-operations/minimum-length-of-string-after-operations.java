class Solution {
    public int minimumLength(String s) {

        HashMap<Character,Integer> mp=new HashMap<>();
        for(char ch: s.toCharArray()) {
             mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        int ans = 0;
        for(int k:mp.values()){
            if((k & 1 )==1){
                ans++;
            }
            else{
                ans+=2;
            }
        }
        return ans;
    }
}