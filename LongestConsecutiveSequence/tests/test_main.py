import pytest
from LongestConsecutiveSequence.main import Solution


@pytest.mark.parametrize(
    "nums, expected", [
        ([100,4,200,1,3,2], 4),
        ([0,3,7,2,5,8,4,6,0,1], 9)
    ]
)
def test_main(nums, expected):
    solution = Solution()
    assert solution.longestConsecutive(nums) == expected
