class Solution {
    public String shortestPalindrome(String s) {

        if (s.length() <= 1)
            return s;

        String rev = new StringBuilder(s).reverse().toString();

        String temp = s + "#" + rev;

        int[] lps = new int[temp.length()];

        for (int i = 1; i < temp.length(); i++) {

            int j = lps[i - 1];

            while (j > 0 && temp.charAt(i) != temp.charAt(j))
                j = lps[j - 1];

            if (temp.charAt(i) == temp.charAt(j))
                j++;

            lps[i] = j;
        }

        int longestPrefix = lps[temp.length() - 1];

        String remain = s.substring(longestPrefix);

        return new StringBuilder(remain).reverse().toString() + s;
    }
}