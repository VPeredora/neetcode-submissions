class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> rowIndexth = new ArrayList<>(rowIndex + 1);

        rowIndexth.add(1);
        int val = 1;
        for (int i = 1; i <= rowIndex; i++) {
            val = (int) ((long) val * (rowIndex - i + 1) / i);
            rowIndexth.add(val);
        }

        return rowIndexth; 
    }
}