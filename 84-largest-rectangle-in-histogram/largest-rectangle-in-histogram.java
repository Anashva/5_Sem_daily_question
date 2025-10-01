class Solution {
    public int largestRectangleArea(int[] arr) {
            Stack<Integer> st=new Stack<>();
            int ans=0;
            for(int i=0;i<arr.length;i++){
                while(!st.isEmpty() && arr[i]<arr[st.peek()]){
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
            int i=arr.length;
            while(!st.isEmpty()){
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
            return ans;
    }
}