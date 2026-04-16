class Solution {
    public int countSeniors(String[] details) {
        int number = 0;
        for (String s : details)
            if (Integer.parseInt(s.substring(11, 13)) > 60) number++;
        return number;
    }
}