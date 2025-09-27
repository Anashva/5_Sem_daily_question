class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        pq.addAll(mp.entrySet());
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> ll=pq.poll();
            char ch=ll.getKey();
            int c=ll.getValue();
            for(int i=0;i<c;i++){
                sb.append(ch);
            }
        }
        return sb.toString();
        // List<Map.Entry<Character,Integer>> ll=new ArrayList<>(mp.entrySet());
        // Collections.sort(ll,(a,b)->b.getValue()-a.getValue());
        // StringBuilder sb=new StringBuilder();
        // for(Map.Entry<Character,Integer> arr:ll){
        //     char ch=arr.getKey();
        //     int c=arr.getValue();
        //     for(int i=0;i<c;i++){
        //         sb.append(ch);
        //     }
        // }
        // return sb.toString();
    }  
}