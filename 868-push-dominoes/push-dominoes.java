class Solution {
    public String pushDominoes(String s) {
        int[] pre=new int[s.length()];
        int[] suff=new int[s.length()];
        int i=0;
        if(s.charAt(i)=='.'){
            pre[0]=-1;
            i=1;
        }
        for( ;i<s.length();i++){
            if(s.charAt(i)=='L'){
                pre[i]=-1;
            }
            else if(s.charAt(i)=='R'){
                pre[i]=i;
            }
            else{
                pre[i]=pre[i-1];
            }
        }
        i=s.length()-1;
        if(s.charAt(i)=='.'){
            suff[i]=-1;
            i=s.length()-2;
        }
        for( ;i>=0;i--){
            if(s.charAt(i)=='L'){
                suff[i]=i;
            }
            else if(s.charAt(i)=='R'){
                suff[i]=-1;
            }
            else{
                suff[i]=suff[i+1];
            }
        }
        char[] arr=new char[s.length()];
        for(int j=0;j<s.length();j++){
            int l=Math.abs(j-pre[j]);
            int r=Math.abs(j-suff[j]);
            if(pre[j]==-1 && suff[j]==-1 ){
                arr[j]='.';
            }
            else if(pre[j]==-1){
                arr[j]='L';
            }
            else if(suff[j]==-1){
                arr[j]='R';
            }
            else if(l>r){
                arr[j]='L';
            }
            else if(r>l){
                arr[j]='R';
            }
            else if(l==r){
                arr[j]='.';
            }
        }
        String str = new String(arr);
        return str;
    }
}