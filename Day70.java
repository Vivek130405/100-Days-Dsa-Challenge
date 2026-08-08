class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        int[] pos = new int[26];

        for (int i = 0; i < order.length(); i++) {
            pos[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {

            String a = words[i];
            String b = words[i + 1];

            int len = Math.min(a.length(), b.length());

            for (int j = 0; j < len; j++) {

                if (a.charAt(j) != b.charAt(j)) {
                    if (pos[a.charAt(j) - 'a'] > pos[b.charAt(j) - 'a']) {
                        return false;
                    }
                    break;
                }
            }

            if (a.length() > b.length() && a.startsWith(b)) {
                return false;
            }
        }

        return true;
    }
}