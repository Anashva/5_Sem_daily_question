class Solution {
    public List<Integer> findGoodIntegers(int n) {
        List<Integer> ll=new ArrayList<>();
        for(int i=1;i<=1000;i++){
            int val=i*i*i;
            ll.add(val);
        }
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<ll.size();i++){
            for(int j=i+1;j<ll.size();j++){
                if(ll.get(i)+ll.get(j)>n){
                    break;
                }
                int x=ll.get(i)+ll.get(j);
                mp.put(x,mp.getOrDefault(x,0)+1);
            }      
        }
        List<Integer> ans=new ArrayList<>();
        for(int x:mp.keySet()){
            if(mp.get(x)>1){
                ans.add(x);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}