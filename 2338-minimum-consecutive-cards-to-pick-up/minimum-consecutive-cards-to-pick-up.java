class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<cards.length;i++){
            if(mp.containsKey(cards[i])){
                if(i-mp.get(cards[i])+1<ans){
                    ans=(i-mp.get(cards[i]))+1;    
                }   
                mp.put(cards[i],i);            
            }
            else{
                mp.put(cards[i],i);
            }
        }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}