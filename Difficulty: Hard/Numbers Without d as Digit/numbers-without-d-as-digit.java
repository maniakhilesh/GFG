class Solution {
    public int countWithout(int n, int d) {
        if (n == 0) return 0;

        String s = String.valueOf(n);
        int len = s.length();

        long[] power = new long[len + 1];
        power[0] = 1;

        for (int i = 1; i <= len; i++) {
            power[i] = power[i - 1] * 9;
        }

        long ans = 0;

        // Numbers with fewer digits
        for (int digits = 1; digits < len; digits++) {
            if (d == 0) {
                ans += 9 * power[digits - 1];
            } else {
                ans += 8 * power[digits - 1];
            }
        }

        // Numbers with same number of digits
        for (int i = 0; i < len; i++) {
            int cur = s.charAt(i) - '0';
            int remaining = len - i - 1;

            int choices = 0;

            if (i == 0) {
                // First digit: 1 to cur-1
                choices = cur - 1;

                if (d != 0 && d < cur) {
                    choices--;
                }
            } else {
                // Other digits: 0 to cur-1
                choices = cur;

                if (d < cur) {
                    choices--;
                }
            }

            ans += (long) choices * power[remaining];

            // If current digit is d, n itself and all further numbers
            // following this prefix are invalid.
            if (cur == d) {
                return (int) ans;
            }
        }

        // n itself does not contain d
        return (int) (ans + 1);
    }
}

