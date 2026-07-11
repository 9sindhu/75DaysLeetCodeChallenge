class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums)
        {
            map.put(num, map.getOrDefault(num,0)+1);
        }
    PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->map.get(a)-map.get(b));

        for(int key:map.keySet())
        {
            pq.add(key);
            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        int result[]=new int[k];
        int i=0;
         while (!pq.isEmpty()) 
        {
            result[i++]=pq.poll();
        }
        return result;
    }
}


// if (nums.length == 0 || k == 0) return new int[]{};
//         Map<Integer,Integer> map = new HashMap<>();
//         for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0)+1);
//         }
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
//         for (Integer key : map.keySet()) {
//             pq.offer(key);
//             while (pq.size() > k) {
//                 pq.poll();
//             }
//         }
//         int[] res = new int[k];
//         int i = 0;
//         for (Integer item : pq) {
//             res[i++] = item;
//         }
//         return res;
//     }