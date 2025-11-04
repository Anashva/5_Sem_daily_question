class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int[] ans=new int[nums.length-k+1];
        for(int i=0;i<=nums.length-k;i++){
            HashMap<Integer,Integer> mp=new HashMap<>();
            for(int j=i;j<i+k;j++){
                mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);
            }
            List<Map.Entry<Integer,Integer>> ll=new ArrayList<>(mp.entrySet());
            Collections.sort(ll,(a,b)->{
                if(a.getValue().equals(b.getValue())){
                    return b.getKey()-a.getKey();
                }
                return b.getValue()-a.getValue();
            });
            int sum=0;
            for(int j=0;j<x && j<ll.size();j++){
                Map.Entry<Integer,Integer> e=ll.get(j);
                int key=e.getKey();
                int value=e.getValue();
                sum+=key*value;
            }
            ans[i]=sum;
        }
        return ans;
        
    }
}