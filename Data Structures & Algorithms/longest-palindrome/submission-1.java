class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : s.toCharArray())
            frequency.merge(c, 1, Integer::sum);
        
        boolean singleLetter = false;
        int length = 0;

        for (Integer num : frequency.values()) {
            if (num % 2 == 0) length += num;
            else  {
                length += num - 1;
                singleLetter = true;
            }
        }
            
        return singleLetter ? length + 1 : length;
    }
}