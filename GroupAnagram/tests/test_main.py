import pytest
from GroupAnagram.main import Solution


def serialise(container: list[list[str]] | list[str]):
    if isinstance(container, list):
        for index in range(len(container)):
            container[index] = serialise(container[index])
        container = sorted(container)
        return ''.join(container)
    if isinstance(container, str):
        return container
    raise ValueError("Unaccepted type")


@pytest.mark.parametrize(
    "strs, expected",
    [
        (["eat", "tea", "tan", "ate", "nat", "bat"], [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]),
        ([""], [[""]]),
        (["a"], [["a"]])
    ]
)
def test_main1(strs, expected):
    solution = Solution()
    assert serialise(solution.groupAnagrams1(strs)) == serialise(expected)

@pytest.mark.parametrize(
    "strs, expected",
    [
        (["eat", "tea", "tan", "ate", "nat", "bat"], [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]),
        ([""], [[""]]),
        (["a"], [["a"]])
    ]
)
def test_main2(strs, expected):
    solution = Solution()
    assert serialise(solution.groupAnagrams2(strs)) == serialise(expected)

@pytest.mark.parametrize(
    "strs, expected",
    [
        (["eat", "tea", "tan", "ate", "nat", "bat"], [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]),
        ([""], [[""]]),
        (["a"], [["a"]])
    ]
)
def test_main3(strs, expected):
    solution = Solution()
    assert serialise(solution.groupAnagrams3(strs)) == serialise(expected)
