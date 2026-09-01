class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        a = [0] * 26
        for ch in s:
            a[ord(ch)-ord('a')] += 1
        b = [0]*26
        for ch in t:
            b[ord(ch)-ord('a')] += 1
        for i in range(26):
            if a[i] != b[i]:
                return False
        return True