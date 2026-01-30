class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int[] ans=reveal(deck);
        return ans;
    }
    public static int[] reveal(int[] arr){
        Arrays.sort(arr);
        Deque<Integer> q=new ArrayDeque<>();
        for(int i=arr.length-1;i>=0;i--){
            if(q.isEmpty()){
                q.add(arr[i]);
            }
            else{
                q.addFirst(q.removeLast());
                q.addFirst(arr[i]);
            }
        }
        int idx=0;
        int[] ans=new int[arr.length];
        for(int i:q){
            ans[idx++]=i;
        }
        return ans;
    }
}