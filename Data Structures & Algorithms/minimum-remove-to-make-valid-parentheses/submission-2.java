class Solution {
    public String minRemoveToMakeValid(String s) {
        int openCnt = 0, closeCnt = 0;

        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == ')') closeCnt++;
        
        StringBuilder result = new StringBuilder(s.length());
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                if (openCnt == closeCnt) continue;
                openCnt++;
            }  else if (c == ')') {
                closeCnt--;
                if (openCnt <= 0) continue;
                openCnt--;
            }

            result.append(c);
        }

        return result.toString();
    }
}