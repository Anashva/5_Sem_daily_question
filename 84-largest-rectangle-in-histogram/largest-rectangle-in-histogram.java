class Solution {
    public int largestRectangleArea(int[] arr) {
            Stack<Integer> st=new Stack<>();
            int ans=0;
            for(int i=0;i<=arr.length;i++){
                int v=(i==arr.length)?0 :arr[i];
                while(!st.isEmpty() && v<arr[st.peek()]){
                    int val=arr[st.pop()];
                    int peek=0;
                    if(st.isEmpty()){
                        peek=-1;
                    }
                    else{
                        peek=st.peek();
                    }
                    int area=val*(i-peek-1);
                    ans=Math.max(ans,area);
                }
                st.push(i);
            }
            return ans;
    }
}