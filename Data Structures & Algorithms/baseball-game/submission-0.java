class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> scores = new ArrayDeque<>();

        for (String op : operations) {
            switch (op) {
                case "C":
                    if (!scores.isEmpty()) scores.pop();
                    break;
                case "D":
                    if (!scores.isEmpty()) scores.push(scores.peek() * 2);
                    break;
                case "+":
                    if (scores.size() > 1) {
                        int firstScore = scores.pop();
                        int secondScore = scores.peek();
                        scores.push(firstScore);
                        scores.push(firstScore + secondScore);
                    }
                    break;
                default: scores.push(Integer.valueOf(op));
            }
        }

        int sum = 0;
        while (!scores.isEmpty())
            sum += scores.pop();
            
        return sum;
    }
}