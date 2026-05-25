class Solution {
    public int leastInterval(char[] tasks, int n) {
        int fre[]=new int[26];
        for(char ch:tasks)
        {
            fre[ch-'A']++;
        }

        int maxfre=0;
        for(int i:fre)
        {
            maxfre=Math.max(maxfre,i);
        }
            int count=0;
        for(int f:fre)
        {
            if(f==maxfre)
                count++;
        }

        int interval=(maxfre-1)*(n+1)+count;

        return Math.max(interval,tasks.length);
    }
}