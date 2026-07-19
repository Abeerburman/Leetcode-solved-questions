class Solution {

    int[] tree;
    int n;

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        n = heights.length;
        tree = new int[4 * n];

        build(heights, 1, 0, n - 1);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int a = queries[i][0];
            int b = queries[i][1];

            int left = Math.min(a, b);
            int right = Math.max(a, b);

            // Same building
            if (left == right) {
                ans[i] = left;
            }

            // Direct movement possible
            else if (heights[left] < heights[right]) {
                ans[i] = right;
            }

            // Search for the first taller building
            else {
                ans[i] = query(
                    1,
                    0,
                    n - 1,
                    right + 1,
                    heights[left]
                );
            }
        }

        return ans;
    }

    // Build segment tree storing maximum height in each range
    private void build(int[] heights, int node, int start, int end) {

        if (start == end) {
            tree[node] = heights[start];
            return;
        }

        int mid = start + (end - start) / 2;

        build(heights, node * 2, start, mid);
        build(heights, node * 2 + 1, mid + 1, end);

        tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
    }

    // Find first index >= left whose height > target
    private int query(
        int node,
        int start,
        int end,
        int left,
        int target
    ) {

        // No valid index in this range
        if (end < left || tree[node] <= target) {
            return -1;
        }

        // Leaf node
        if (start == end) {
            return start;
        }

        int mid = start + (end - start) / 2;

        // Search left side first
        int result = query(
            node * 2,
            start,
            mid,
            left,
            target
        );

        if (result != -1) {
            return result;
        }

        // Search right side
        return query(
            node * 2 + 1,
            mid + 1,
            end,
            left,
            target
        );
    }
}