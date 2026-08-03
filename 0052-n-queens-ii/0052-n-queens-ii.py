class Solution:
    def totalNQueens(self, n: int) -> int:
        columns = set()
        left_diagonal = set()   # row - col
        right_diagonal = set()  # row + col

        def backtrack(row):
            if row == n:
                return 1

            count = 0

            for col in range(n):
                if (
                    col in columns
                    or row - col in left_diagonal
                    or row + col in right_diagonal
                ):
                    continue

                columns.add(col)
                left_diagonal.add(row - col)
                right_diagonal.add(row + col)

                count += backtrack(row + 1)

                columns.remove(col)
                left_diagonal.remove(row - col)
                right_diagonal.remove(row + col)

            return count

        return backtrack(0)