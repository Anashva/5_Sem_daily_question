class Solution {
    public int maxArea(int[] height) {
        int ans=Integer.MIN_VALUE;
        int i=0;
        int j=height.length-1;
        while(i<j){
            int area=Math.min(height[i],height[j]);
            ans=Math.max(ans,area*(j-i));
            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return ans;
    }
}