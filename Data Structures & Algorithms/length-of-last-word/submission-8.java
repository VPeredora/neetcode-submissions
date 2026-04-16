class Solution {
    public int lengthOfLastWord(String s) {
        int pointer = s.length() - 1, length = 0;
        
        while (s.charAt(pointer) == ' ') pointer--;
        while (pointer >=0 && s.charAt(pointer) != ' ') {
            length++;
            pointer--;
        }

        return length;
    }
}