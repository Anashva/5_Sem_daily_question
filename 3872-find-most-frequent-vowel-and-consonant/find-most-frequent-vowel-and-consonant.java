class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character,Integer> vowel=new HashMap<>();
        HashMap<Character,Integer> cons=new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                vowel.put(ch,vowel.getOrDefault(ch,0)+1);
            }
            else{
                cons.put(ch,cons.getOrDefault(ch,0)+1);
            }
        }
        int v=0;
        int c=0;
        for(int k:vowel.values()){
            v=Math.max(v,k);
        }
        for(int k:cons.values()){
            c=Math.max(c,k);
        }
        return c+v;
    }
}