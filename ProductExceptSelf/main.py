from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        N = len(nums)
        forward = [1] * N

        for i in range(1, N):
            forward[i] = forward[i - 1] * nums[i - 1]

        temp = 1
        for i in range(N - 2, -1, -1):
            temp = temp * nums[i + 1]
            forward[i] = temp * forward[i]

        return forward
