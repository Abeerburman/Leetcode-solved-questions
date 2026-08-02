class Solution:
    def solveNQueens(self, n: int) -> list[list[str]]:
        answer = []
        board = [["."] * n for _ in range(n)]

        columns = set()
        left_diagonal = set()   # row - col
        right_diagonal = set()  # row + col

        def backtrack(row):
            if row == n:
                answer.append(["".join(r) for r in board])
                return

            for col in range(n):
                if (
                    col in columns
                    or row - col in left_diagonal
                    or row + col in right_diagonal
                ):
                    continue

                board[row][col] = "Q"
                columns.add(col)
                left_diagonal.add(row - col)
                right_diagonal.add(row + col)

                backtrack(row + 1)

                board[row][col] = "."
                columns.remove(col)
                left_diagonal.remove(row - col)
                right_diagonal.remove(row + col)

        backtrack(0)
        return answer