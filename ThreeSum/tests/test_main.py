import pytest
from ThreeSum.main import Solution


@pytest.mark.parametrize(
    "nums, expected", [
        ([-1, 0, 1, 2, -1, -4], [[-1, -1, 2], [-1, 0, 1]]),
        ([0, 1, 1], []),
        ([0, 0, 0], [[0, 0, 0]])
    ]
)
def test_main1(nums, expected):
    solution = Solution()
    assert sorted(solution.threeSum1(nums)) == expected


@pytest.mark.parametrize(
    "nums, expected", [
        ([-1, 0, 1, 2, -1, -4], [[-1, -1, 2], [-1, 0, 1]]),
        ([0, 1, 1], []),
        ([0, 0, 0], [[0, 0, 0]]),
        ([-2, 0, 0, 2, 2], [[-2, 0, 2]]),
        ([-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0],
         [[-5, 1, 4], [-4, 0, 4], [-4, 1, 3], [-2, -2, 4], [-2, 1, 1], [0, 0, 0]])
    ]
)
def test_main2(nums, expected):
    solution = Solution()
    assert sorted(solution.threeSum2(nums)) == expected
