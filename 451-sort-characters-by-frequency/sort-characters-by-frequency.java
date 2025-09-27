class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }
        List<Map.Entry<Character,Integer>> ll=new ArrayList<>(mp.entrySet());
        Collections.sort(ll,(a,b)->b.getValue()-a.getValue());
        StringBuilder sb=new StringBuilder();
        for(Map.Entry<Character,Integer> arr:ll){
            char ch=arr.getKey();
            int c=arr.getValue();
            for(int i=0;i<c;i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }  
}