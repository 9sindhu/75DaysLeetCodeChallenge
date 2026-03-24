class Solution {
    public int maxArea(int[] height) {
    int l=0;
    int r=height.length-1;
    int max_water=0;
    while(l<r)
    {
        int h=Math.min(height[l],height[r]);
        int width=r-l;
        int area=h*width;

        max_water=Math.max(max_water, area);

        if(height[l]<height[r])
        {
            l++;
        }
        else
        {
            r--;
        }
    }    
    return max_water;
    
    
    }
}