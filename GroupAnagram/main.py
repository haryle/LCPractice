from typing import List


class Solution:
    def groupAnagrams1(self, strs: List[str]) -> List[List[str]]:
        """
        Encodes the strings based on frequency.

        Let m be the maximum size of each str in strs, n be the length of strs
        Complexity Analysis: O(m x n)

        Not optimal because each string.count is done for each character in the alphabet
        - i.e check the whole string 26 times for each increment
        """
        anagram_group = {}

        for string in strs:
            signature = tuple([string.count(chr(i)) for i in range(97, 123)])
            if signature in anagram_group:
                anagram_group[signature].append(string)
            else:
                anagram_group[signature] = [string]
        return list(anagram_group.values())

    def groupAnagrams2(self, strs: List[str]) -> List[List[str]]:
        """
        Encodes the strings based on frequency.

        Let m be the maximum size of each str in strs, n be the length of strs
        Complexity Analysis: O(m x n)

        More optimal
        """
        anagram_group = {}

        for string in strs:
            signature = [0] * 26
            for char in string:
                signature[ord(char) - ord('a')] += 1
            signature = tuple(signature)
            if signature in anagram_group:
                anagram_group[signature].append(string)
            else:
                anagram_group[signature] = [string]
        return list(anagram_group.values())

    def groupAnagrams3(self, strs: List[str]) -> List[List[str]]:
        """
        Encodes the strings based on frequency of the sorted array.

        Let m be the maximum size of each str in strs, n be the length of strs
        Complexity Analysis: O(mlog(m) x n)

        """
        anagram_group = {}

        for _string in strs:
            string = ''.join(sorted(_string))
            if string in anagram_group:
                anagram_group[string].append(_string)
            else:
                anagram_group[string] = [_string]
        return list(anagram_group.values())
