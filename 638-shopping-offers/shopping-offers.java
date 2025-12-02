class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return offer(price,special,needs,0);
    }
    public int offer(List<Integer> price,List<List<Integer>> offer,List<Integer> need,int idx){
        if(idx>=offer.size()){
            int ans=0;
            for(int i=0;i<need.size();i++){
                ans+=need.get(i)*price.get(i);
            }
            return ans; 
        }
        if(possible(need,offer.get(idx))){
            List<Integer> ll=new ArrayList<>();
            for(int i=0;i<need.size();i++){
                ll.add(need.get(i)-offer.get(idx).get(i));
            }
            int take=(offer.get(idx).get(offer.get(idx).size()-1))+offer(price,offer,ll,idx);
            int skip=offer(price,offer,need,idx+1);
            return Math.min(take,skip);
        }
        else{
            return offer(price,offer,need,idx+1);
        }
    }
    public boolean possible(List<Integer> need,List<Integer> offer){
        for(int i=0;i<need.size();i++){
            if(need.get(i)<offer.get(i)){
                return false;
            }
        }
        return true;
    }
}

// in this we have checked if offer is more than need than we will skip that otherwise update the need according to special offer