class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        StringBuilder prefix = new StringBuilder(strs[0]);

        for (int i = 1; i < strs.length; i++)
            while (!strs[i].startsWith(prefix.toString()) && prefix.length() > 0)
                prefix.deleteCharAt(prefix.length() - 1);

        return prefix.toString();
    }
}