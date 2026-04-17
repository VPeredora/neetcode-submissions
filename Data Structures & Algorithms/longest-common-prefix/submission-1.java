class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];

        StringBuilder prefix = new StringBuilder("");
        for (int i = 0; i < strs[0].length() && i < strs[1].length(); i++) {
            char c = strs[0].charAt(i);
            if (c == strs[1].charAt(i)) {
                prefix.append(c);
            } else { break; }
        }
        
        for (String str : strs) {
            if (!str.startsWith(prefix.toString())) {
                while (prefix.length() > 0 && !str.startsWith(prefix.toString())) 
                    prefix.deleteCharAt(prefix.length() - 1);
            }
        }
        return prefix.toString();
    }
}