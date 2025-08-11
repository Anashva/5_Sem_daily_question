class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int[] answer=new int[queries.length];
        List<Integer> ll=new ArrayList<>();
        int pow=1;
        while(n>0){
            if(n%2==1){
                ll.add(pow);
            }
            pow=pow*2;
            n/=2;
        }
        for(int i=0;i<queries.length;i++){
            int si=queries[i][0];
            int ei=queries[i][1];
            long p=1;
            for(int j=si;j<=ei;j++){
                p=(p*ll.get(j))%1000000007;
            }
            answer[i]=(int)p;
        }
        return answer;
    }
}