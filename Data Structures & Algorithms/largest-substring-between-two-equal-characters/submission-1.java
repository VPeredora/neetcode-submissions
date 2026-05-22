class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int maxLength = -1, left = 0;

        while (left < s.length() && s.length() - left > maxLength) {
            int right = s.length() - 1;
            while (right > left && s.charAt(left) != s.charAt(right)) right--;
            
            if (s.charAt(left) == s.charAt(right)) maxLength = Math.max(maxLength, right - left - 1);
            left++; 
        }

        return maxLength;
    }
}