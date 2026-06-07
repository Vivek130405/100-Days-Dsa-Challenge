class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder result = new StringBuilder();
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // Traverse both strings from end
        while (i >= 0 || j >= 0 || carry == 1) {

            int sum = carry;

            // Add digit from a
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            // Add digit from b
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            // Add binary digit to result
            result.append(sum % 2);

            // Update carry
            carry = sum / 2;
        }

        // Reverse final result
        return result.reverse().toString();
    }
}