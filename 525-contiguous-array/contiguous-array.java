class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int prefixsum=0;
        map.put(0,-1);
        int maxlen=0;
        for(int i=0;i<nums.length;i++)
        {
            prefixsum+=(nums[i]==0)?-1:1;
            if(map.containsKey(prefixsum))
            maxlen=Math.max(maxlen,i-map.get(prefixsum));
            else
            map.put(prefixsum,i);
        }
        return maxlen;

    }
}