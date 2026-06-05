class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
        return nums[0];
        int m1=solve(nums,0,n-2);
        int m2=solve(nums,1,n-1);
        return Math.max(m1,m2);     
    }

    public static int solve(int nums[],int start,int end)
    {
        int prev1=0;
        int prev2=0;

        for(int i=start; i<=end;i++)
        {
            int curr=Math.max(prev2,prev1+nums[i]);

            prev1=prev2;
            prev2=curr;
        }
        return prev2;
    }
}