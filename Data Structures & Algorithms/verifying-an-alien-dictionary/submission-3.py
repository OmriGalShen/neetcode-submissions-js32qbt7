class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        d = { v: i for i, v in enumerate(order)}
        for i in range(len(words)-1):
            word1 = words[i]
            word2 = words[i+1]
            f = False
            for j in range(min(len(word1), len(word2))):
                c = d[word1[j]] - d[word2[j]]
                if c > 0:
                    return False
                elif c < 0:
                    f = True
                    break
            else:
                if len(word1) > len(word2):
                    return False
        return True

