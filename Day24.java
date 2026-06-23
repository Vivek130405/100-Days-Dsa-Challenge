class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {

        if (n1 == 0) return 0;

        int index = 0;      // current index in s2
        int count = 0;      // number of completed s2

        Map<Integer, int[]> map = new HashMap<>();

        int s1Count = 0;

        while (s1Count < n1) {

            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(index)) {
                    index++;
                    if (index == s2.length()) {
                        count++;
                        index = 0;
                    }
                }
            }

            s1Count++;

            if (map.containsKey(index)) {

                int[] prev = map.get(index);

                int prevS1 = prev[0];
                int prevCount = prev[1];

                int cycleS1 = s1Count - prevS1;
                int cycleCount = count - prevCount;

                int remaining = n1 - s1Count;

                int times = remaining / cycleS1;

                count += times * cycleCount;
                s1Count += times * cycleS1;

            } else {
                map.put(index, new int[]{s1Count, count});
            }
        }

        return count / n2;
    }
}