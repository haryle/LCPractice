class Solution:
    def isPalindrome(self, s: str) -> bool:
        N = len(s)
        forward_index = 0
        backward_index = N - 1
        while forward_index < backward_index:
            if not (s[forward_index].isalnum()):
                forward_index += 1
                continue

            if not (s[backward_index].isalnum()):
                backward_index -= 1
                continue

            if s[forward_index].lower() == s[backward_index].lower():
                forward_index += 1
                backward_index -= 1
                continue
            return False
        return True
