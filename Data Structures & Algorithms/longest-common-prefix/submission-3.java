class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        
        Arrays.sort(strs);
        String first = strs[0], last = strs[strs.length - 1];
        int minLength = Math.min(strs[0].length(), strs[strs.length - 1].length());

        for (int i = 0; i < minLength; i++)
            if (first.charAt(i) != last.charAt(i))
                return first.substring(0, i);
        return strs[0];
    }
}