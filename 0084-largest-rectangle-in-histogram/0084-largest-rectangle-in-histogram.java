class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int maxlength=0;
        int width;
        int n=heights.length;
        for(int i=0;i<=n;i++)
        {
            int currentnumber=(i==n)?0:heights[i];
            while(!stack.isEmpty()&& 
                         heights[stack.peek()]>currentnumber)
            {
               int height=heights[ stack.pop()];
                if (stack.isEmpty()) {
                    width = i;
                }

                else
                {
                    width=i-stack.peek()-1;
                }
                int area=height*width;
                maxlength=Math.max(maxlength,area);
            }
            stack.push(i);
        }
        return maxlength;
    }
}
 