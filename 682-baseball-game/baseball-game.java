class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<operations.length;i++){
            String s=operations[i];
            if(s.equals("+")){
                int a=st.pop();
                int b=st.peek();
                st.push(a);
                st.push(a+b);
            }
            else if(s.equals("D")){
                int a=st.peek();
                st.push(2*a);
            }
            else if(s.equals("C")){
                st.pop();
            }
            else{
                int num=Integer.parseInt(s);
                st.push(num);
            }
        }
        int sum=0;
        while(!st.isEmpty()){
            sum+=st.pop();
        }
        return sum;
    }
}