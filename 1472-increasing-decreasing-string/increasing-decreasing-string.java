class Solution {
    public String sortString(String s) {
        HashMap<Character,Integer> mp=new HashMap<>();
        for(char ch:s.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }

        int n=s.length();
        StringBuilder sb=new StringBuilder();
        while(n>0){
            for(char ch='a';ch<='z';ch++){
                if(mp.containsKey(ch)){
                    sb.append(ch);
                    int count = mp.get(ch);
                    n--;
                    if (count == 1) {
                        mp.remove(ch);
                    } else {
                        mp.put(ch, count - 1);
                    }
                }
            }
            for(char ch='z';ch>='a';ch--){
                if(mp.containsKey(ch)){
                    sb.append(ch);
                    n--;
                    int count = mp.get(ch);
                    if (count == 1) {
                        mp.remove(ch);
                    } else {
                        mp.put(ch, count - 1);
                    }
                }
            }
        }
        return sb.toString();
    }
}