class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> scores = new ArrayDeque<>();
        int sum = 0;

        for (String op : operations) {
            if (op.equals("C")) sum -= scores.pop();
            else if (op.equals("D")) {
                scores.push(2 * scores.peek());
                sum += scores.peek();
            } 
            else if (op.equals("+")) {
                int first = scores.pop();
                int total = first + scores.peek();
                scores.push(first); scores.push(total);
                sum += total;
            }
            else {
                scores.push(Integer.valueOf(op));
                sum += scores.peek();
            }
        }

        return sum;
    }
}