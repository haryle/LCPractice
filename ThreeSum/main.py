from typing import List


class Solution:
    def threeSum1(self, nums: List[int]) -> List[List[int]]:
        """
        Brute force solution to threeSum, complexity is O(n^3)
        """
        results = set()
        N = len(nums)
        for base in range(N - 2):
            for left_ptr in range(base + 1, N - 1):
                for right_ptr in range(left_ptr + 1, N):
                    if (nums[base] + nums[left_ptr] + nums[right_ptr]) == 0:
                        results.add(tuple(sorted([nums[base], nums[left_ptr], nums[right_ptr]])))
        return [list(item) for item in results]

    def threeSum2(self, nums: List[int]) -> List[List[int]]:
        """
        Brute force solution to threeSum, complexity is O(n^3)
        """
        results = set()
        countDict = {}
        for num in nums:
            countDict[num] = countDict.get(num, 0) + 1

        while (len(countDict) != 0):
            num, count = countDict.popitem()
            if count >= 3 and num * 3 == 0:
                results.add(tuple([num, num, num]))
            if count >= 2:
                complement = 0 - num * 2
                if complement in countDict:
                    results.add(tuple(sorted([num, num, complement])))
            for another_num, another_count in countDict.items():
                complement = 0 - num - another_num
                if complement in countDict:
                    if complement == another_num:
                        if another_count >= 2:
                            results.add(tuple(sorted([num, another_num, another_num])))
                    else:
                        results.add(tuple(sorted([num, another_num, complement])))
        return [list(item) for item in results]

    def threeSum3(self, nums: List[int]) -> List[List[int]]:
        # TODO: learn threeSum3
        res = []
        nums.sort()

        for i, a in enumerate(nums):
            # Skip positive integers
            if a > 0:
                break

            if i > 0 and a == nums[i - 1]:
                continue

            l, r = i + 1, len(nums) - 1
            while l < r:
                threeSum = a + nums[l] + nums[r]
                if threeSum > 0:
                    r -= 1
                elif threeSum < 0:
                    l += 1
                else:
                    res.append([a, nums[l], nums[r]])
                    l += 1
                    r -= 1
                    while nums[l] == nums[l - 1] and l < r:
                        l += 1

        return res
