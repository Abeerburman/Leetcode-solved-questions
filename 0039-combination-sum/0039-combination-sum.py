class Solution:
    def combinationSum(self, candidates: list[int], target: int) -> list[list[int]]:
        result = []

        def backtrack(start, current, total):
            # Target reached
            if total == target:
                result.append(current.copy())
                return

            # Sum exceeded
            if total > target:
                return

            for i in range(start, len(candidates)):
                current.append(candidates[i])

                # i is passed again because the same number
                # can be used unlimited times
                backtrack(i, current, total + candidates[i])

                # Undo the choice
                current.pop()

        backtrack(0, [], 0)
        return result