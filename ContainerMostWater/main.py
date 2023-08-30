from typing import List


class Solution:
    def maxArea1(self, height: List[int]) -> int:
        left, right = 0, len(height) - 1
        left_val, right_val = height[left], height[right]
        max_area = min(height[left], height[right]) * (right - left)

        while (left < right):
            if right_val < left_val:
                while (right_val >= height[right]):
                    right -= 1
                    if (right == left) or (right <= 0):
                        break
                right_val = height[right]
                max_area = max(max_area, min(height[left], height[right]) * (right - left))
                continue
            if left_val <= right_val:
                while (left_val >= height[left]):
                    left += 1
                    if (left == right) or (left >= (len(height) - 1)):
                        break
                left_val = height[left]
                max_area = max(max_area, min(height[left], height[right]) * (right - left))
                continue
        return max_area

    def maxArea2(self, height: List[int]) -> int:
        # TODO: Review this method, prove it right
        l, r = 0, len(height) - 1
        res = 0

        while l < r:
            res = max(res, min(height[l], height[r]) * (r - l))
            if height[l] < height[r]:
                l += 1
            elif height[r] <= height[l]:
                r -= 1

        return res
