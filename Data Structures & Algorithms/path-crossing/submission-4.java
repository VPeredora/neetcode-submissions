class Solution {
   private record Point(int x, int y) {}

    public boolean isPathCrossing(String path) {
        Set<Point> units = new HashSet<>();
        int x = 0, y = 0;
        units.add(new Point(x, y));

        for (char quarter : path.toCharArray()) {
            switch (quarter) {
                case 'N': {y += 1; break;}
                case 'S': {y -= 1; break;}
                case 'E': {x += 1; break;}
                case 'W': {x -= 1; break;}
            }
            if (!units.add(new Point(x, y))) return true;
        }

        return false;
    }
}