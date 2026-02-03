class Solution {
    public boolean isTrionic(int[] nums) {
        int i=0;
        int a=0;
        int b=0;
        int c=0;
        while(i+1<nums.length && nums[i+1]>nums[i]){
                c++;
                i++;
        }
        if(c==0){
            return false;
        }
        while(i+1<nums.length && nums[i]>nums[i+1]){
                i++;
                b++;
        }
        if(b==0){
            return false;
        }
        while(i+1<nums.length && nums[i+1]>nums[i]){
                a++;
                i++;
        }
        if(a==0 ){
            return false;
        }
        return i==nums.length-1;
    }
}