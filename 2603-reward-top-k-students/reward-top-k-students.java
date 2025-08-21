class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        HashSet<String> pos=new HashSet<>();
        HashSet<String> neg=new HashSet<>();
        for(String i:positive_feedback){
            pos.add(i);
        }
        for(String i:negative_feedback){
            neg.add(i);
        }
        ArrayList<Integer> ll=new ArrayList<>();
        int[][] ans=new int[report.length][2];
        for(int i=0;i<report.length;i++){
            String[] arr=report[i].split(" ");
            int val=0;
            for(String s:arr){
                if(pos.contains(s)){
                    val+=3;
                }
                if(neg.contains(s)){
                    val--;
                }
            }
            ans[i][0]=student_id[i];
            ans[i][1]=val;
        }
        Arrays.sort(ans, (a, b) -> {
            if (a[1] != b[1]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0]; 
            }
        });

        for(int i=0;i<k;i++){
            ll.add(ans[i][0]);
        }
        return ll;
    }
}