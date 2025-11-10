class Solution {
    public int maxDiff(int num) {
        int min=num;
        int max=num;
        for(int x=0;x<=9;x++){
            for(int y=0;y<=9;y++){
                String s=replace(num,x,y);
                if(s.charAt(0)!='0'){
                    int t=Integer.parseInt(s);
                    min=Math.min(min,t);
                    max=Math.max(max,t);
                }
            }
        }
        return max-min;
    }
    public String replace(int num,int x,int y){
        StringBuilder sb=new StringBuilder(String.valueOf(num));
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)-'0'==x){
                sb.setCharAt(i,(char)('0'+y));
            }
        }
        return sb.toString();
    }
}