from typing import List


class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        counter = set(nums)
        return len(counter) != len(nums)
