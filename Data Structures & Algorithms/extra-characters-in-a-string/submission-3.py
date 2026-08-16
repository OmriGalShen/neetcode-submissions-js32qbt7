class TrieNode:
    def __init__(self) -> None:
        self.children = {}
        self.final = False

class Solution:
    def minExtraChar(self, s: str, dictionary: List[str]) -> int:
        d = set(dictionary)
        dp = {}
        head = self.build_trie(dictionary)

        def dfs(i):
            if i in dp:
                return dp[i]
            if i == len(s):
                return 0
            
            res = 1 + dfs(i+1)
            curr = head
            for j in range(i, len(s)):
                c = s[j]
                if c not in curr.children:
                    break
                curr = curr.children[c]
                if curr.final:
                    res = min(res, dfs(j+1))
            dp[i] = res
            return res
        
        return dfs(0)

    def build_trie(self, dictionary):
        head = TrieNode()
        for word in dictionary:
            curr = head
            for c in word:
                if c not in curr.children:
                    curr.children[c] = TrieNode()
                curr = curr.children[c]
            curr.final = True
        return head

        