class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new ArrayDeque<>(Arrays.stream(students).boxed().toList());
        Deque<Integer> stack = new ArrayDeque<>(Arrays.stream(sandwiches).boxed().toList());

        while (!stack.isEmpty()) {
            int sandwich = stack.pop();
            int amount = queue.size();

            for (int i = 0; i < amount; i++) {
                int student = queue.poll();
                if (student == sandwich) break;
                queue.add(student);
            }

            if (amount == queue.size()) return amount;
        }

        return 0;
    }
}