class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<int[]> timeVisits = new ArrayList<>(timestamp.length);
        for (int i = 0; i < timestamp.length; i++)
            timeVisits.add(new int[]{timestamp[i], i});

        timeVisits.sort((a, b) -> Integer.compare(a[0], b[0]));

        Map<String, List<String>> userVisits = new HashMap<>();
        for (int[] time : timeVisits)
            userVisits.computeIfAbsent(username[time[1]], k -> new ArrayList<>()).add(website[time[1]]);

        Map<String, Integer> frequency = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : userVisits.entrySet()) {
            List<String> visits = entry.getValue();
            Set<String> patterns = new HashSet<>();

            for (int i = 0; i < visits.size() - 2; i++)
                patterns.add(String.join("#", 
                    visits.get(i), visits.get(i + 1), visits.get(i + 2)));
            
            for (String pattern : patterns)
                frequency.merge(pattern, 1, Integer::sum);
        }

        String result = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            String pattern = entry.getKey();
            int count = entry.getValue();
            if (count > maxCount || (count == maxCount && pattern.compareTo(result) < 0)) {
                maxCount = count;
                result = pattern;
            }
        }

        return List.of(result.split("#"));  
    }
}