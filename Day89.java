class Solution {
    public String sortSentence(String s) {

        String[] words = s.split(" ");
        String[] result = new String[words.length];

        for (String word : words) {

            int n = word.length();
            int position = word.charAt(n - 1) - '1';

            result[position] = word.substring(0, n - 1);
        }

        String ans = "";

        for (int i = 0; i < result.length; i++) {

            ans += result[i];

            if (i < result.length - 1) {
                ans += " ";
            }
        }

        return ans;
    }
}