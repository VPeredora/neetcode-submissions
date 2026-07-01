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
        int pivot = arr[end];
        int i = begin;

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                int swapTemp = arr[i];
                arr[i++] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i];
        arr[i] = arr[end];
        arr[end] = swapTemp;

        return i;
    }
}