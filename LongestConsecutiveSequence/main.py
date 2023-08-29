from typing import List


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        table = set(nums)

        max_length = 0
        while len(table) != 0:
            length = 1
            item = table.pop()
            cmin = item
            cmax = item
            while (cmin - 1) in table:
                length += 1
                cmin = cmin - 1
                table.remove(cmin)
            while (cmax + 1) in table:
                length += 1
                cmax = cmax + 1
                table.remove(cmax)
            max_length = max(max_length, length)
        return max_length
