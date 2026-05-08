class Solution {
    public boolean checkInclusion(String s1, String s2) {
       int k=s1.length();
       int n=s2.length();
       int fre[]=new int[26];
       int window[]=new int[26];

       if(k>n)
       return false;

       for(int i=0;i<k;i++)
       {
        char ch=s1.charAt(i);
        fre[ch-'a']++;
       } 
       for(int i=0;i<k;i++)
       {
        char ch=s2.charAt(i);
        window[ch-'a']++;
       }
       if(Arrays.equals(fre,window))
       return true;

        for(int i=k;i<n;i++)
        {
            
            window[s2.charAt(i)-'a']++;

            window[s2.charAt(i-k)-'a']--;

            if(Arrays.equals(fre,window))
            return true;

        }
        return false;
    
    }
}