class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int minIdx=Integer.MAX_VALUE;
        int n=nums.length;
        int sum=0;
        for(int right=0;right<n;right++)
        {
            sum+=nums[right];

            while(sum>=target)
            {
                minIdx=Math.min(minIdx, right-left+1);
                sum-=nums[left];
                // sum+=nums[ right];
                 
                left++;
            }
        }
        return minIdx==Integer.MAX_VALUE?0:minIdx;
    }
}