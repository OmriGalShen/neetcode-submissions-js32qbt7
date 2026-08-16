class Solution:
    def minExtraChar(self, s: str, dictionary: List[str]) -> int:
        d = set(dictionary)
        dp = {}

        def dfs(i):
            if i in dp:
                return dp[i]
            if i == len(s):
                return 0
            
            res = 1 + dfs(i+1)

            for j in range(i, len(s)):
                word = s[i:j+1]
                if word in d:
                    res = min(res, dfs(j+1))
            dp[i] = res
            return res
        
        return dfs(0)