class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int N = students.length, amount = N;
        int[] queue = Arrays.copyOf(students, N);
        int[] temp;

        for (int sandwich : sandwiches) {
            boolean eaten = false;
            int passed = 0;

            for (int i = 0; i < amount; i++) {
                passed++;
                if (sandwich == queue[i]) {
                    eaten = true; amount--;
                    break;
                }
            }

            if (!eaten) return amount;

            if (amount > 0) {
                temp = new int[amount];
                int pointer = 0;
                for (int j = 0; j < amount; j++) {
                    if (passed < amount + 1) {
                        temp[j] = queue[passed++]; 
                        continue;
                    }
                    temp[j] = queue[pointer++];
                }
                queue = temp;
            }
        }

        return 0;
    }
}