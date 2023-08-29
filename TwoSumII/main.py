from typing import List


class Solution:
    def twoSum1(self, nums: List[int], target: int) -> List[int]:
        """
        Solution uses hash map method. Time complexity: O(n), space complexity O(n)
        """
        N = len(nums)
        index_map = {nums[index]: index for index in range(N)}

        for index in range(N):
            complement = target - nums[index]
            if (complement in index_map) and (index_map[complement] != index):
                return [index + 1, index_map[complement] + 1]

    def twoSum2(self, nums: List[int], target: int) -> List[int]:
        """
        Solution uses two pointers.
        Time complexity: O(n), space complexity O(1)
        """
        left, right = 0, len(nums) - 1
        while left < right:
            total = nums[right] + nums[left]
            if total > target:
                right -= 1
            elif total < target:
                left += 1
            else:
                return [left + 1, right + 1]
