class Solution {
    public int[] canSeePersonsCount(int[] arr) {
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[arr.length];
        int n=arr.length;
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            int c=0;
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                c++;
                st.pop();
            }
            if(st.size()>0){
               c++;
            }
            ans[i]=c;
            st.push(i);
        }
        
        return ans;
    }
}