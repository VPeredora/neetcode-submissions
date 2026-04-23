class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            int indexOfAt = email.indexOf('@');
            String local = email.substring(0, indexOfAt);
            String domain = email.substring(indexOfAt);

            int indexOfPlus = local.indexOf('+');
            if (indexOfPlus != -1) local = local.substring(0, indexOfPlus);

            uniqueEmails.add(local.replace(".", "") + '@' + domain);
        }

        return uniqueEmails.size();
    }
}