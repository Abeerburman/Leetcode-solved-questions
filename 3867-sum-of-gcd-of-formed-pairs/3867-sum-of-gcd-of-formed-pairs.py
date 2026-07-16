from math import gcd

class Solution:
    def gcdSum(self, nums: list[int]) -> int:
        prefix_gcd = []
        current_max = 0

        # Construct prefixGcd
        for num in nums:
            current_max = max(current_max, num)
            prefix_gcd.append(gcd(num, current_max))

        # Sort prefixGcd
        prefix_gcd.sort()

        # Pair smallest with largest
        left = 0
        right = len(prefix_gcd) - 1
        ans = 0

        while left < right:
            ans += gcd(prefix_gcd[left], prefix_gcd[right])
            left += 1
            right -= 1

        return ans