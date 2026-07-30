class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // int[][] arr=new int[intervals.length+newInterval.length-1][2];
        // for(int i=0;i<intervals.length;i++){
        //     arr[i][0]=intervals[i][0];
        //     arr[i][1]=intervals[i][1];
        // }
        // arr[arr.length-1][0]=newInterval[0];
        // arr[arr.length-1][1]=newInterval[1];
        // Arrays.sort(arr,(a,b)->(a[0]-b[0]));
        // int start=arr[0][0];
        // int end=arr[0][1];
        // ArrayList<int[]> ll=new ArrayList<>();
        // for(int i=1;i<arr.length;i++){
        //     if(end>=arr[i][0]){
        //         end=Math.max(end,arr[i][1]);
        //     }
        //     else{
        //         int[] num=new int[2];
        //         num[0]=start;
        //         num[1]=end;
        //         ll.add(num);
        //         start=arr[i][0];
        //         end=arr[i][1];
        //     }
        // }
        // int[] num=new int[2];
        // num[0]=start;
        // num[1]=end;
        // ll.add(num);
        // return ll.toArray(new int[ll.size()][2]);

        int i=0;
        int n=intervals.length;
        List<int[]> ll=new ArrayList<>();
        while(i<n && intervals[i][1]<newInterval[0]){
            ll.add(intervals[i]);
            i++;
        }
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
            newInterval[1]=Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        ll.add(newInterval);
        while(i<n){
            ll.add(intervals[i]);
            i++;
        }
         return ll.toArray(new int[ll.size()][]);
        
    }
}
// add all non overlapping interval, merge all merged interval, add all after merged interval remaining