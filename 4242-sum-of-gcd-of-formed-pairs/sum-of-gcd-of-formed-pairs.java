class Solution {
    public long gcdSum(int[] nums) {
        int[] pref=new int[nums.length];
        pref[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pref[i]=Math.max(pref[i-1],nums[i]);
        }
        int[] gcd=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            gcd[i]=GCD(pref[i],nums[i]);
        }
        Arrays.sort(gcd);
        int i=0;
        int j=nums.length-1;
        long sum=0;
        while(i<j){
            sum+=GCD(gcd[i],gcd[j]);
            i++;
            j--;
        }
        return sum;
    }
    public int GCD(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}