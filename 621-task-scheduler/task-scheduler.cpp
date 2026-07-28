class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        vector<int> freq(26);
        for(char ch:tasks){
            freq[ch-'A']++;
        }
        sort(freq.begin(),freq.end());
        int mx=freq[25]-1;
        int idle=n*(mx);
        for(int i=24;i>=0 && freq[i]>0;i--){
            idle-=min(freq[i],mx);
        }
        if(idle<=0){
            return tasks.size();
        }
        return idle+tasks.size();
    }
};
// we will count the frequency of each taks and find the total idle slot needed by max task then will fill slot by other task  if still idle slot needed then we can add to toal task other wise it will be no of task