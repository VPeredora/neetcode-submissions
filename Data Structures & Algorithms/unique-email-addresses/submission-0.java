class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
            if (parts[0].contains("+")) parts[0] = parts[0].substring(0, parts[0].indexOf('+'));
            String uniqueEmail = parts[0].replace(".", "") + "@" + parts[1];
            uniqueEmails.add(uniqueEmail);
        }
        return uniqueEmails.size();
    }
}