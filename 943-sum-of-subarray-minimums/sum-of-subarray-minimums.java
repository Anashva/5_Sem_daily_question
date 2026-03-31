class Solution {
    public int sumSubarrayMins(int[] arr) {
        long ans=0;
        int mod=1000000007;
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<=arr.length;i++){
            while(!st.isEmpty() && (i==n || arr[st.peek()]>arr[i])){
                int mid=st.pop();  
                int left=st.isEmpty() ? mid+1 : mid-st.peek();
                int right=i-mid;
                ans=(ans+(long)arr[mid]*left*right)%mod;  
            }
            st.push(i);
        }
        return (int)ans;
    }
}