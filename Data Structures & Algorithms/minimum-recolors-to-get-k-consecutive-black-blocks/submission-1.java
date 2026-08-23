class Solution {
    public int minimumRecolors(String blocks, int k) {
        int op = 0;
        for (int i = 0; i < k; i++)
            if (blocks.charAt(i) == 'W') op++;
        
        int whites = op;
        for (int j = k; j < blocks.length(); j++) {
            if (blocks.charAt(j - k) == 'W') whites--;
            if (blocks.charAt(j) == 'W') whites++;
            op = Math.min(op, whites);
        }

        return op;
    }
}