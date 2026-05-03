class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] pcount=new int[26];
        int[] window=new int[26];

        if(s.length()<p.length())
        return result;

        int k=p.length();
        for(int i=0;i<k;i++)
        {
            pcount[p.charAt(i)-'a']++;
        }

        for(int i=0;i<k;i++)
        {
            window[s.charAt(i)-'a']++;
        }
            if(Arrays.equals(pcount,window))
            result.add(0);
        

        for(int i=k;i<s.length();i++)
        {
            window[s.charAt(i)-'a']++;
            window[s.charAt(i-k)-'a']--;
            if(Arrays.equals(pcount,window))
            result.add(i-k+1);
        }
        return result;
    }
}


// public List<Integer> findAnagrams(String s, String p) {
//     List<Integer> result = new ArrayList<>();
//     if (s.length() < p.length()) return result;

//     int[] pCount = new int[26];
//     int[] window = new int[26];

//     // Step 1: Fill pCount
//     for (char c : p.toCharArray()) {
//         pCount[c - 'a']++;
//     }

//     int k = p.length();

//     // Step 2: First window
//     for (int i = 0; i < k; i++) {
//         window[s.charAt(i) - 'a']++;
//     }

//     // Step 3: Check first window
//     if (Arrays.equals(pCount, window)) {
//         result.add(0);
//     }

//     // Step 4: Slide window
//     for (int i = k; i < s.length(); i++) {
//         // Add new char
//         window[s.charAt(i) - 'a']++;

//         // Remove old char
//         window[s.charAt(i - k) - 'a']--;

//         // Compare
//         if (Arrays.equals(pCount, window)) {
//             result.add(i - k + 1);
//         }
//     }

//     return result;
// }