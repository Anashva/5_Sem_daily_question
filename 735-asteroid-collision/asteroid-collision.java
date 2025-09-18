class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int num:asteroids){
            boolean flag=true;
            while(flag && !st.isEmpty() && st.peek()>0 && num<0){
                int k=st.pop();
                if(Math.abs(k)>Math.abs(num)){
                    st.push(k);
                    flag=false;
                }
                else if(Math.abs(k)==Math.abs(num)){
                    flag=false;
                }
            }
            if(flag){
                st.push(num);
            }
        }
        int[] arr=new int[st.size()];
        for(int i=arr.length-1;i>=0;i--){
            arr[i]=st.pop();
        }
        return arr;
    }
}