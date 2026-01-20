class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            boolean flag=false;
            int val=asteroids[i];
            while(!st.isEmpty() && st.peek()>0 && val<0){
                int k=Math.abs(val);
                if(k==st.peek()){
                    st.pop();
                    flag=true;
                    break;
                }
                if(st.peek()>k){
                    flag=true;
                    break;
                }
                else{
                    st.pop();
                }
            }
            if(!flag){
                st.push(val);
            }
        }
        int[] ans=new int[st.size()];
        int k=0;
        for(int i:st){
            ans[k++]=i;
        }
        return ans;
    }
}