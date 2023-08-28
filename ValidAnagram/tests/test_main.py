import pytest

from ValidAnagram.main import Solution


@pytest.mark.parametrize(
    "s, t, expected",
    [("anagram", "nagaram", True),
     ("rat", "car", False)]
)
def test_main(s, t, expected):
    solution = Solution()
    assert solution.isAnagram(s, t) == expected
