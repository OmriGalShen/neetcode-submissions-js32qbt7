class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        d = { v: i for i, v in enumerate(order)}
        for i in range(len(words)-1):
            w1,w2 = words[i], words[i+1]
            for j in range(min(len(w1), len(w2))):
                c = d[w1[j]] - d[w2[j]]
                if c > 0:
                    return False
                elif c < 0:
                    break
            else:
                if len(w1) > len(w2):
                    return False
        return True

