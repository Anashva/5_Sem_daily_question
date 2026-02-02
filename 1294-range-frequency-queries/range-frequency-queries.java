class RangeFreqQuery {
    HashMap<Integer,List<Integer>> mp;
    public RangeFreqQuery(int[] arr) {
        mp=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!mp.containsKey(arr[i])){
                mp.put(arr[i],new ArrayList<>());
                mp.get(arr[i]).add(i);
            }
            else{
                mp.get(arr[i]).add(i);
            }
        }
    }
    
    public int query(int left, int right, int value) {
        if(!mp.containsKey(value)){
            return 0;
        }
        List<Integer> ll=mp.get(value);
        return higher(right,ll)-lower(left,ll);
    }
    public int lower(int val,List<Integer> ll){
        int l=0;
        int r=ll.size();
        while(l<r){
            int mid=l+(r-l)/2;
            if(ll.get(mid)>=val){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    public int higher(int val,List<Integer> ll){
        int l=0;
        int r=ll.size();
        while(l<r){
            int mid=l+(r-l)/2;
            if(ll.get(mid)<=val){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return l;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */