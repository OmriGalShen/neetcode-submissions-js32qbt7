class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        N,M =len(haystack), len(needle)
        if M > N:
            return -1
        for i in range(N-M+1):
            j =0
            while j < M:
                if haystack[i+j] != needle[j]:
                    break
                j += 1
            if j == M:
                return i
        return -1