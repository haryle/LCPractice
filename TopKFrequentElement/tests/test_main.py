import pytest
from TopKFrequentElement.main import Solution


@pytest.mark.parametrize(
    "nums, k, expected",[
        ([1,1,1,2,2,3], 2, [1,2]),
        ([1], 1, [1])
    ])
def test_main(nums, k, expected):
    solution = Solution()
    assert set(solution.topKFrequent(nums, k)) == set(expected)
