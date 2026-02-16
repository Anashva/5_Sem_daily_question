class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        boolean[] visit=new boolean[students.length];
        return compat(students,mentors,0,visit);
    }
    public int compat(int[][] stud,int[][]ment,int idx,boolean[] visit){
        if(idx==stud.length){
            return 0;
        }
        int ans=0;
        for(int i=0;i<stud.length;i++){
            if(!visit[i]){
                visit[i]=true;
                int count=0;
                for(int j=0;j<stud[i].length;j++){
                    if(stud[idx][j]==ment[i][j]){
                        count++;
                    }
                }
                ans=Math.max(ans,count+compat(stud,ment,idx+1,visit));
                visit[i]=false;
            }
        }
        return ans;
    }
}