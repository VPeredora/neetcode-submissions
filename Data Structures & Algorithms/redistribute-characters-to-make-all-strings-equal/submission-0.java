class Solution {
    public boolean makeEqual(String[] words) {
        int[] frequency = new int[26];
        
        for (String word : words) 
            for (char c : word.toCharArray())
                frequency[c - 'a']++;
        
        for (int num : frequency)
            if (num > 0 && num % words.length != 0) return false;

        return true;
    }
}