import pytest

from ValidPalindrome.main import Solution


@pytest.mark.parametrize(
    "s, expected",
    [("A man, a plan, a canal: Panama", True),
     ("race a car", False),
     (" ", True),
     ("zxc",False)
     ]
)
def test_main(s, expected):
    solution = Solution()
    assert solution.isPalindrome(s) == expected
