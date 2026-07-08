class Solution {
    int solve(int n,int dp[])
    {
        if(n==0)
        {
            return 1;
        }
        if(dp[n]!=-1)return dp[n];
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++)
        {
            int x=solve(n-i,dp);
            ans=Math.max(ans,i*x);
        }
        return dp[n]=ans;
    }
    public int integerBreak(int n) {
        if(n<=3) return n-1;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
}