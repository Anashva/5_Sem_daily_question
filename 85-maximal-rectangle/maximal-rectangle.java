class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] arr=new int[matrix[0].length];
        int ans=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0'){
                    arr[j]=0;
                }
                else{
                    arr[j]++;
                }
            }
            ans=Math.max(ans,histogram(arr));
        }
        return ans;
    }
    public static int histogram(int[] arr){
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