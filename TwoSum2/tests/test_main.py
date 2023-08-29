import pytest
from TwoSum2.main import Solution


@pytest.mark.parametrize(
    "nums, target, expected", [
        ([2, 7, 11, 15], 9, [1, 2]),
        ([2, 3, 4], 6, [1, 3]),
        ([3, 3], 6, [1, 2]),
        ([-1, 0], -1, [1, 2]),
    ]
)
def test_main1(nums, target, expected):
    solution = Solution()
    assert solution.twoSum1(nums, target) == expected

@pytest.mark.parametrize(
    "nums, target, expected", [
        ([2, 7, 11, 15], 9, [1, 2]),
        ([2, 3, 4], 6, [1, 3]),
        ([3, 3], 6, [1, 2]),
        ([-1, 0], -1, [1, 2]),
    ]
)
def test_main2(nums, target, expected):
    solution = Solution()
    assert solution.twoSum2(nums, target) == expected
