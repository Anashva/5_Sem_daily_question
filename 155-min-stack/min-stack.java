class MinStack {
    Stack<Integer> st=new Stack<>();
    Stack<Integer> mst=new Stack<>();
    public void push(int val) {
        st.push(val);
        if(mst.isEmpty()){
            mst.push(val);
        }
        else{
            mst.push(Math.min(val, mst.peek()));
        }
    }
    
    public void pop() {
        st.pop();
        mst.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return mst.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */