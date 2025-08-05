class ProductOfNumbers {
    ArrayList<Integer> ll;
    public ProductOfNumbers() {
        ll=new ArrayList<>();
    }
    
    public void add(int num) {
        ll.add(num);
    }
    
    public int getProduct(int k) {
        if(ll.size()<k){
            return 0;
        }
        long ans=1;
        int i=ll.size()-1;
        while(k-->0){
            ans=ans*(long)ll.get(i);
            i--;
        }
        return (int)ans;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */