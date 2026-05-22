class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] indices = new int[26];
        Arrays.fill(indices, -1);
        int length = -1;

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (indices[c] > -1) 
                length = Math.max(length, i - indices[c] - 1);
            else indices[c] = i;
        }
        
        return length;
    }
}