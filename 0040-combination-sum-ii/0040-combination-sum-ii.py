class Solution:
    def combinationSum2(self, candidates: list[int], target: int) -> list[list[int]]:
        candidates.sort()
        result = []

        def backtrack(start, current, remaining):
            if remaining == 0:
                result.append(current.copy())
                return

            for i in range(start, len(candidates)):

                # Skip duplicate values at the same recursion level
                if i > start and candidates[i] == candidates[i - 1]:
                    continue

                # Since the array is sorted, no later value can work
                if candidates[i] > remaining:
                    break

                current.append(candidates[i])

                # i + 1 because each number can be used only once
                backtrack(i + 1, current, remaining - candidates[i])

                # Undo the choice
                current.pop()

        backtrack(0, [], target)
        return result