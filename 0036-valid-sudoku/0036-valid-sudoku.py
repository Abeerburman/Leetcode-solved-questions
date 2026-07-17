class Solution:
    def isValidSudoku(self, board: list[list[str]]) -> bool:
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxes = [set() for _ in range(9)]

        for r in range(9):
            for c in range(9):
                value = board[r][c]

                if value == ".":
                    continue

                # Find the 3x3 box index
                box_index = (r // 3) * 3 + (c // 3)

                # Check duplicate
                if (value in rows[r] or
                    value in cols[c] or
                    value in boxes[box_index]):
                    return False

                rows[r].add(value)
                cols[c].add(value)
                boxes[box_index].add(value)

        return True