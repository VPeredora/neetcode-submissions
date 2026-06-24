class Solution {
    public String simplifyPath(String path) {
        String[] files = path.split("/+");
        Deque<String> canonical = new ArrayDeque<>();

        for (String file : files) {
            if (file.equals("..")) {
                if (!canonical.isEmpty()) canonical.pop();
            } else if (!file.equals("") && !file.equals(".")) 
                canonical.push(file);
        }

        StringBuilder result = new StringBuilder();
        Iterator<String> it = canonical.descendingIterator();
        while (it.hasNext())
            result.append('/').append(it.next());

        return result.length() == 0 ? "/" : result.toString();
    }
}