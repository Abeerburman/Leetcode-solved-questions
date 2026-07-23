class Solution {
    public int longestWPI(int[] hours) {
        int maxLength = 0;

        for (int i = 0; i < hours.length; i++) {

            int tiring = 0;
            int nonTiring = 0;

            for (int j = i; j < hours.length; j++) {

                if (hours[j] > 8) {
                    tiring++;
                } else {
                    nonTiring++;
                }

                if (tiring > nonTiring) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }
}