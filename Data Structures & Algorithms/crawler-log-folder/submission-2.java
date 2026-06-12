class Solution {
    public int minOperations(String[] logs) {
        Deque<String> folders = new ArrayDeque<>();

        for (String log : logs)
            if (log.equals("../")) {
                if (!folders.isEmpty()) folders.pop();
            } else if (!log.equals("./")) folders.push(log);

        return folders.size();
    }
}
