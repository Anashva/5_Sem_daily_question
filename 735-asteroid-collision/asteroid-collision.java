class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            int val=asteroids[i];
            boolean flag=false;
            while(!st.isEmpty() && st.peek()>0 && val<0){
                int k=st.peek();
                if(k<Math.abs(val)){
                    st.pop();
                }
                else if(k==Math.abs(val)){
                    st.pop();
                    flag=true;
                    break;
                }
                else if(k>Math.abs(val)){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                st.push(val);
            }
        }
        int[] ans=new int[st.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}