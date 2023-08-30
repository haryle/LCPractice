import pytest

from ContainerMostWater.main import Solution


@pytest.mark.parametrize(
    "height, expected", [
        ([1, 8, 6, 2, 5, 4, 8, 3, 7], 49),
        ([1,1], 1),
        ([1,2,3,4], 4),
        ([1,2,1], 2),
        ([1,8,100,2,100,4,8,3,7], 200)
    ]
)
def test_main1(height, expected):
    solution = Solution()
    assert solution.maxArea1(height) == expected

@pytest.mark.parametrize(
    "height, expected", [
        ([1, 8, 6, 2, 5, 4, 8, 3, 7], 49),
        ([1,1], 1),
        ([1,2,3,4], 4),
        ([1,2,1], 2),
        ([1,8,100,2,100,4,8,3,7], 200)
    ]
)
def test_main2(height, expected):
    solution = Solution()
    assert solution.maxArea2(height) == expected
