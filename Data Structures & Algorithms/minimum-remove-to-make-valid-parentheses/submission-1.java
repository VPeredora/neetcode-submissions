class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder filtered = new StringBuilder(s);

        for (int i = 0; i < filtered.length(); i++) {
            char c = filtered.charAt(i);

            if (c == '(') stack.push(i);
            else if (c == ')' && !stack.isEmpty()) stack.pop();
            else if (c == ')' && stack.isEmpty()) filtered.setCharAt(i, '\0');
        }

        while (!stack.isEmpty())
            filtered.setCharAt(stack.pop(), '\0');
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < filtered.length(); i++) {
            char c = filtered.charAt(i);
            if (c != '\0') result.append(c);
        }

        return result.toString();
    }
}