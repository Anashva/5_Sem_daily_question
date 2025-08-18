class Solution {
    public long countOfSubstrings(String s, int k) {
        return count(s,k)-count(s,k+1);
    }
    public long count(String s,int k){
        int len=s.length();
        long ans=0;
        int c=0;
        int j=0;
        Map<Character, Integer> mp = new HashMap<>();
        for(int i=0;i<len;i++){
            if(vowel(s.charAt(i))){
                mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
            }
            else{
                c++;
            }
            while(mp.size()==5 && c>=k){
                ans+=len-i;
                if (vowel(s.charAt(j))) {
                    mp.put(s.charAt(j), mp.get(s.charAt(j)) - 1);
                    if (mp.get(s.charAt(j)) == 0) {
                        mp.remove(s.charAt(j));
                    }
                } 
                else {
                    c--;
                }
                j++;
            }
        }
        return ans;
    }
    public boolean vowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
            return true;
        }
        return false;
    }
}