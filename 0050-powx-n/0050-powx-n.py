class Solution:
    def myPow(self, x: float, n: int) -> float:

        N = n

        if N < 0:
            x = 1 / x
            N = -N

        ans = 1

        while N > 0:
            if N % 2 == 1:
                ans *= x

            x *= x
            N //= 2

        return ans