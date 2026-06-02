class Solution {
    public int minCostClimbingStairs(int[] cost) {
         int prev=cost[0];
        int prev1=cost[1];
        int n=cost.length;

        for(int i=2;i<n;i++)
        {
            int curr=cost[i]+Math.min(prev,prev1);
            prev=prev1;
            prev1=curr;

        }
        return Math.min(prev,prev1);

    }
}