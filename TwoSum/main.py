from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        N = len(nums)
        index_map = {nums[index]: index for index in range(N)}

        for index in range(N):
            complement = target - nums[index]
            if (complement in index_map) and (index_map[complement] != index):
                return [index, index_map[complement]]
