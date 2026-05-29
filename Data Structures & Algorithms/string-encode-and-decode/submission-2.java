class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String str : strs)
            encoded.append(str.length()).append("#").append(str);
        System.out.println(encoded);
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int pointer = 0;

        while (pointer < str.length()) {
            int hashIndex = str.indexOf("#", pointer);
            if (hashIndex < 0) break;

            int length = Integer.parseInt(str.substring(pointer, hashIndex));
            int payloadStart = hashIndex + 1;
            int payloadEnd = payloadStart + length;
            
            String data = str.substring(payloadStart, payloadEnd);
            decoded.add(data);

            pointer = payloadEnd;
        }

        return decoded;
    }
}
