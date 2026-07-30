class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ll=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(end>=intervals[i][0]){
                end=Math.max(end,intervals[i][1]);
            }
            else{
                int[] num=new int[2];
                num[0]=start;
                num[1]=end;
                ll.add(num);
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        int[] arr=new int[2];
        arr[0]=start;
        arr[1]=end;
        ll.add(arr);
        return ll.toArray(new int[ll.size()][2]);
    }
}