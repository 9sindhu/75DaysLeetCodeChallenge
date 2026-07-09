class Solution {

    public static boolean isVowel(char ch)
    {
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }

    public int maxVowels(String s, int k) {
        int n=s.length();
        int wc=0;
        int count=0;
        for(int i=0;i<k;i++)
        {
            if(isVowel(s.charAt(i)))
            count++;
        }

        wc=count;

        for(int i=k;i<n;i++)
        {
            if(isVowel(s.charAt(i-k)))
            count--;
            if(isVowel(s.charAt(i)))
            count++;

            wc=Math.max(wc,count);

        }
        return wc;
    }
}