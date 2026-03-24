class SummaryRanges {
    TreeSet<int[]> st;
    public SummaryRanges() {
        st=new TreeSet<>((a,b)->a[0]-b[0]);
    }
    
    public void addNum(int val) {
        int[] curr={val,val};
        // finding interval according to starting value of interval
        int[] left=st.floor(curr);
        int[] right=st.ceiling(curr);
         
        if(left!=null && left[1]>=val){
            return;
        }

        boolean mergeL=(left!=null && left[1]+1==val);
        boolean mergeR=(right!=null && right[0]==val+1);
        if(mergeL && mergeR){
            left[1]=right[1];
            st.remove(right);
        }
        else if(mergeL){
            left[1]=Math.max(left[1],val);
        }
        else if(mergeR){
            st.remove(right);
            st.add(new int[]{val,right[1]});
        }
        else{
            st.add(curr);
        }

    }
    
    public int[][] getIntervals() {
        return st.toArray(new int[st.size()][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */