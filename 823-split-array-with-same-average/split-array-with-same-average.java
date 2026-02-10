class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        
        int total=0;
        int n=nums.length;
        for(int i:nums){
            total+=i;
        }
        for(int i=1;i<=n-1;i++){
            if((i*total)%n!=0){
                continue;

            }
            HashMap<String,Boolean> mp = new HashMap<>();
            int s1=(i*total)/n;
            if(split(nums,s1,0,i,n,mp)){
                return true;
            }
        }
        return false;
    }
    public boolean split(int[] nums,int target,int idx,int i,int n,HashMap<String,Boolean> mp){
        if(target==0 && i==0){
            return true;
        }
        if(idx==n){
            return false;
        }
        if (target < 0 || i < 0) return false;
        if (n - idx < i) return false;

        String key=idx+"|"+i+"|"+target;
        if(mp.containsKey(key)){
            return mp.get(key);
        }
        boolean res=split(nums,target-nums[idx],idx+1,i-1,n,mp) || split(nums,target,idx+1,i,n,mp);
        mp.put(key,res);
        return res;
    }
    // public boolean split(int[] nums,int idx,int sum1,int count1,int sum2,int count2){
    //     if(idx==nums.length){
    //         if(count1>0 && count2>0){
    //             if(count1*sum2==count2*sum1){
    //                 return true;
    //             }
    //         }
    //         return false;
    //     }
    //     String s= idx + "|" + sum1 + "|" + count1 + "|" + sum2 + "|" + count2;
    //     if(mp.containsKey(s)){
    //         return mp.get(s);
    //     }
    //     boolean a=split(nums,idx+1,sum1+nums[idx],count1+1,sum2,count2);
    //     boolean b=split(nums,idx+1,sum1,count1,sum2+nums[idx],count2+1);
    //     boolean res=a || b;
    //     mp.put(s,res);
    //     return a || b;
    // }
}

// s1=(n1*total)/n;