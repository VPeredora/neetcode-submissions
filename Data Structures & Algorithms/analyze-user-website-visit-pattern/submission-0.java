class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<int[]> timestamps = new ArrayList<>(timestamp.length);
        for (int i = 0; i < timestamp.length; i++)
            timestamps.add(new int[]{timestamp[i], i});

        timestamps.sort((a, b) -> Integer.compare(a[0], b[0]));
        
        Map<String, List<String>> visits = new HashMap<>();
        for (int[] time : timestamps)
            visits.computeIfAbsent(username[time[1]], k -> new ArrayList<>()).add(website[time[1]]);
        
        Map<String, Integer> frequency = new HashMap<>();
        for (String user : visits.keySet()) {
            List<String> userVisits = visits.get(user);
            Set<String> patterns = new HashSet<>();

            for (int i = 0; i < userVisits.size(); i++)
                for (int j = i + 1; j < userVisits.size(); j++)
                    for (int k = j + 1; k < userVisits.size(); k++)
                        patterns.add(userVisits.get(i) + "#" + userVisits.get(j) + "#" + userVisits.get(k));
            
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