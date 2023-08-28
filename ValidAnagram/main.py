class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        if set(s) != set(t):
            return False

        count_dict = {}

        for ch in s:
            count_dict[ch] = 1 + count_dict.get(ch, 0)

        for ch in set(t):
            if t.count(ch) != count_dict[ch]:
                return False
        return True
