class Solution {
    long[] prefix;

    public long minPartitionScore(int[] nums, int k) {
        int n = nums.length;
        prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long[][] dp = new long[k + 1][n + 1];
        for (long[] row : dp) Arrays.fill(row, Long.MAX_VALUE / 4);

        dp[0][0] = 0;

        // base case
        for (int i = 1; i <= n; i++) {
            long s = prefix[i];
            dp[1][i] = s * (s + 1) / 2;
        }

        for (int t = 2; t <= k; t++) {
            Deque<Line> hull = new ArrayDeque<>();

            for (int j = t - 1; j <= n - 1; j++) {
                long B = prefix[j];
                long m = -B;
                long c = dp[t - 1][j] + B*(B+1)/2 -B;
                addLine(hull, m, c);

                long A = prefix[j + 1];
                long best = query(hull, A);
                dp[t][j + 1] = best + A*(A+1)/2;
            }
        }

        return dp[k][n];
    }

    class Line {
        long m, c;
        double xLeft;
        Line(long m, long c) {
            this.m = m;
            this.c = c;
            this.xLeft = Double.NEGATIVE_INFINITY;
        }
        long value(long x) { 
            return m * x + c; 
        }
    }

    public double intersect(Line l1, Line l2) {
        return (double)(l2.c - l1.c) / (l1.m - l2.m);
    }

    public void addLine(Deque<Line> hull, long m, long c) {
        Line newLine = new Line(m, c);
        while (!hull.isEmpty()) {
            Line last = hull.peekLast();
            double x = intersect(newLine, last);
            if (x <= last.xLeft) {
                hull.pollLast();
            } else {
                newLine.xLeft = x;
                break;
            }
        }
        if (hull.isEmpty()){
            newLine.xLeft = Double.NEGATIVE_INFINITY;
        } 
        hull.addLast(newLine);
    }

    public long query(Deque<Line> hull, long x) {
        while (hull.size() >= 2) {
            Line first = hull.peekFirst();
            Line second = hull.toArray(new Line[0])[1];
            if (second.xLeft <= x) {
                hull.pollFirst();
            }
            else {
                break;
            }
        }
        return hull.peekFirst().value(x);
    }
}
