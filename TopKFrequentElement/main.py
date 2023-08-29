from typing import List


class Solution:
    #TODO: Implement a solution that uses Priority Queue
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counter = {}
        for num in nums:
            counter[num] = counter.get(num, 0) + 1

        counter = list(sorted(counter.items(), key=lambda item: item[1], reverse=True))
        return [item[0] for item in counter[:k]]
