class Solution {
    public String decodeString(String s) {
        Deque<String> decoded = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c != ']') decoded.push(String.valueOf(c));
            else {
                StringBuilder region = new StringBuilder();
                while (!decoded.peek().equals("["))
                    region.insert(0, decoded.pop());
                decoded.pop();

                StringBuilder k = new StringBuilder();
                while (!decoded.isEmpty() && Character.isDigit(decoded.peek().charAt(0)))
                    k.insert(0, decoded.pop());

                int amount = Integer.parseInt(k.toString());
                decoded.push(region.toString().repeat(amount));
            }
        }

        StringBuilder result = new StringBuilder();
        while (!decoded.isEmpty())
            result.insert(0, decoded.pop());

        return result.toString();
    }
}