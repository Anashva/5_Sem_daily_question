class NumArray {
    int[] BIT; 
    int[] nums;
    public NumArray(int[] nums) {
        this.nums=nums;
        BIT=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            updt(i,nums[i]);
        }
    }
    
    public void update(int i, int val){
        int diff=val-nums[i];
        nums[i]=val;
        updt(i,diff);
    }
    public void updt(int i,int val){
        i++;
        while(i<BIT.length){
            BIT[i]+=val;
            i+= (i & -i);
        }
    }
    
    public int sumRange(int left, int right) {
        return query(right)-query(left-1);
    }
    public int query(int i){
        int sum=0;
        i++;
        while(i>0){
            sum+=BIT[i];
            i-=i & -i;
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */