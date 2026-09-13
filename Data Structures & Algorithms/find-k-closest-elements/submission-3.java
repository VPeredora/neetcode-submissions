class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int closest = 0;
        for (int i = 1; i < arr.length; i++)
            if (Math.abs(arr[closest] - x) > Math.abs(arr[i] - x)) 
                closest = i;

        List<Integer> result = new ArrayList();
        result.add(arr[closest]);
        int l = closest - 1, r = closest + 1;
        
        while (result.size() < k) {
            if (l >= 0 && r < arr.length) {
                int diff = Math.abs(arr[l] - x) - Math.abs(arr[r] - x);
                
                if (diff <= 0) result.add(arr[l--]);
                else result.add(arr[r++]);
                
            } else if (l >= 0) result.add(arr[l--]);
            else result.add(arr[r++]);
        }

        result.sort(Comparator.naturalOrder());
        return result;
    }
}