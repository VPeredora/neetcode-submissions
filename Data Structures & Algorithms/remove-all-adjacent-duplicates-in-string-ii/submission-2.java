class Solution {
    public String removeDuplicates(String s, int k) {
        char[] result = s.toCharArray();
        int[] count = new int[s.length()];
        int i = 0;
        
        for (int j = 0; j < s.length(); j++) {
            result[i] = result[j];
            count[i] = 1;

            if (i > 0 && result[i - 1] == result[i]) {
                count[i] += count[i - 1];
                if (count[i] == k) i -= k;
            }
            
            i++;
        }

        return new String(result, 0, i);
    }
}