class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans=new ArrayList<>();
        ans.add(words[0]);

        for(int i=1;i<words.length;i++)
        {
            char[] w1=words[i-1].toCharArray();
            char[] w2=words[i].toCharArray();
            Arrays.sort(w1);
            Arrays.sort(w2);
            if(!Arrays.equals(w1,w2))
            {
                    ans.add(words[i]);
            }
        }
        return ans;

    }
}