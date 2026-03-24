class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[] arr=new int[n*m];
        int k=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[k++]=grid[i][j]%(12345);
            }
        }
        int[] t=product(arr);
        int x=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=t[x++];
            }
        }
        return grid;
        
    }
    public static int[] product(int[]arr) {
		int n=arr.length;
		int [] left=new int[n];
		int[] right=new int[n];
		left[0]=1;
		for(int i=1;i<n;i++) {
			left[i]=(left[i-1]*arr[i-1])%(12345);
			
			
		}
		right[n-1]=1;
		for(int i=n-2;i>=0;i--) {
			right[i]=(right[i+1]*arr[i+1])%(12345);
			
		}
	    int[] answer=new int[n];
		for(int i=0;i<n;i++) {
            answer[i]=(left[i]*right[i])%(12345);
		
		}
		return answer;	
	}

}