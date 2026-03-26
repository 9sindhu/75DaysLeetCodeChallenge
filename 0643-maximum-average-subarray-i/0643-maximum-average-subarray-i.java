class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int n = nums.length;
        int wSum = 0;
        for (int i = 0; i < k; i++) {
            wSum += nums[i];
        }
        
        int maxSum = wSum;
          
        for (int i = k; i < n; i++) {
            wSum += nums[i];       
            wSum -= nums[i - k];   
            
            maxSum = Math.max(maxSum, wSum);
        }
        
        
        return (double) maxSum / k;
    }
}
    