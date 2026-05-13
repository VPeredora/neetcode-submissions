class Solution {
    public boolean isPathCrossing(String path) {
        Map<Integer, Set<Integer>> units = new HashMap<>();
        int x = 0, y = 0;
        units.put(x, new HashSet(Set.of(y)));

        for (char quarter : path.toCharArray()) {
            switch (quarter) {
                case 'N': {y += 1; break;}
                case 'S': {y -= 1; break;}
                case 'E': {x += 1; break;}
                case 'W': {x -= 1; break;}
            }
            if (!units.computeIfAbsent(x, v -> new HashSet()).add(y)) return true;
        }

        return false;
    }
}