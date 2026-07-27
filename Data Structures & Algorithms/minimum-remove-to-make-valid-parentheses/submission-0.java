class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder(s.length());
        int opened = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') opened++;
            else if (c == ')' && opened > 0) opened--;
            else if (c == ')' && opened <= 0) continue;
            
            result.append(c);
        }
        
        for (int j = result.length() - 1; j >= 0 && opened > 0; j--) {
            if (result.charAt(j) == '(') {
                result.deleteCharAt(j);
                opened--;
            }
        }

        return result.toString();
    }
}