class Solution {
    public int pivotIndex(int[] nums) {
        int leftsum=0;
        int totalsum=0;
        for(int i=0;i<nums.length;i++)
        totalsum+=nums[i];
        for(int i=0;i<nums.length;i++)
        {
        int rightsum=totalsum-nums[i]-leftsum;
        if(leftsum==rightsum)
        return i;

        leftsum+=nums[i];
        }
        return -1;
    }
}