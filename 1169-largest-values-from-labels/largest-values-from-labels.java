class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        HashMap<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            mp.computeIfAbsent(labels[i], k -> new ArrayList<>()).add(values[i]);
        }
        for (List<Integer> list : mp.values()) {
            list.sort(Collections.reverseOrder());
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(List<Integer> list : mp.values()){
            for(int i = 0; i < Math.min(useLimit, list.size()); i++){
                pq.add(list.get(i));
            }
        }
        int ans=0;
        while (numWanted-- > 0 && !pq.isEmpty()) {
            ans += pq.poll();
        }
        return ans;
    }
}