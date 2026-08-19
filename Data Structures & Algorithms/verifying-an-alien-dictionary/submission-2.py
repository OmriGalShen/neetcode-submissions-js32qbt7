class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        arr = [0]*26
        for i, v in enumerate(order):
            arr[ord(v)-ord('a')] = i
        def comp(a, b):
            v = arr[ord(a)-ord('a')]- arr[ord(b)-ord('a')]
            return v
        for i in range(len(words)-1):
            word1 = words[i]
            word2 = words[i+1]
            f = False
            for j in range(min(len(word1), len(word2))):
                c = comp(word1[j], word2[j])
                if c > 0:
                    return False
                elif c < 0:
                    f = True
                    break
            if not f and len(word1) > len(word2):
                return False
        return True

