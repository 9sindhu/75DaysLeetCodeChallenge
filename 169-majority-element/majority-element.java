class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int majority=nums.length/2;
        for(int num:nums)
        {
            map.put(num,map.getOrDefault(num,0)+1);
            if(map.get(num)>majority)
            return num;
        }
        return -1;
    }
}