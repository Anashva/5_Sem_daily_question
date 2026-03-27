class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int time=0;
        for(int[] e:courses){
            if(time+e[0]<=e[1]){
                time+=e[0];
                pq.add(e[0]);
            }
            else if(!pq.isEmpty()){
                if(pq.peek()>e[0]){
                    time-=pq.poll();
                    time+=e[0];
                    pq.add(e[0]);
                }
            }
        }
        return pq.size();

        
    }
    // public int schedule(int[][] courses,int idx,int total){
    //     if(idx==courses.length){
    //         return 0;
    //     }
    //     if(dp[idx][total]!=null){
    //         return dp[idx][total];
    //     }
    //     int take=0;
    //     if(total+courses[idx][0]<=courses[idx][1]){
    //         take=1+schedule(courses,idx+1,total+courses[idx][0]);
    //     }
    //     int skip=schedule(courses,idx+1,total);
    //     return dp[idx][total]=Math.max(take,skip);

    // }

}