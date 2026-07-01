class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int mid = begin + (end - begin) / 2;

        if (arr[mid] < arr[begin]) swap(arr, begin, mid);
        if (arr[end] < arr[begin]) swap(arr, begin, end);
        if (arr[end] < arr[mid]) swap(arr, mid, end);
        swap(arr, mid, end);

        int pivot = arr[end];
        int i = begin;

        for (int j = begin; j < end; j++)
            if (arr[j] <= pivot) swap(arr, i++, j);

        swap(arr, i, end);
        
        return i;
    }

    private static void swap(int[] arr, int a, int b) {
        int swapTemp = arr[a];
        arr[a] = arr[b];
        arr[b] = swapTemp;
    }
}