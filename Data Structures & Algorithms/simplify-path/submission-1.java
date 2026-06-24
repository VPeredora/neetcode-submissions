class Solution {
    public String simplifyPath(String path) {
        String[] files = path.split("/+");
        Deque<String> canonical = new ArrayDeque<>();

        for (String file : files) {
            if (file.equals("..")) {
                if (!canonical.isEmpty()) canonical.removeLast();
            } else if (!file.equals(".") && !file.equals("")) {
                canonical.addLast(file);
            }  
        }

        return "/" + String.join("/", canonical);
    }
}