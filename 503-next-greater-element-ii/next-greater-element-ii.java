class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n=arr.length;
       Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];
        Arrays.fill(ans,-1);
        for(int i=0;i<2*n;i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i%n]){
                ans[st.pop()]=arr[i%n];
            }
            if(i<n){
                st.push(i);
            }
        }
        return ans;
    }
}