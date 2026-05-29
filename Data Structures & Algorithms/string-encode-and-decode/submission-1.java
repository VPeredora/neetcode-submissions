class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String str : strs)
            encoded.append(str.length()).append('#').append(str);

        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        Scanner scanner = new Scanner(str);
        scanner.useDelimiter("#");

        while (scanner.hasNextInt()) {
            int length = scanner.nextInt();
            scanner.skip("#");

            String data = scanner.findWithinHorizon(".{" + length +"}", length);
            decoded.add(data);
        }

        scanner.close();
        return decoded;
    }
}
