class Solution {
    int mod=1000000007;
    public int countPermutations(int[] complexity) {
        int c=0;
        long ans=1;
        for(int i=1;i<complexity.length;i++){
            if(complexity[i]<=complexity[0]){
                c++;
                break;
            }
            else{
                ans=(ans*i)%mod;//(n-1)! permutation possible
            }
        }
        if(c>0){
            return 0;
        }
        return (int)ans;
    }
}