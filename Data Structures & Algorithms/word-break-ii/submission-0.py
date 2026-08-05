class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        res = []
        valid_words = set(wordDict)
        def rec(i, word_i, words):
            word = s[word_i: i+1]
            if i == len(s)-1:
                if word in valid_words:
                    words.append(word)
                    res.append(' '.join(words))
                    words.pop()
                return
            if word in valid_words:
                words.append(word)
                rec(i+1, i+1, words)
                words.pop()
            rec(i+1, word_i, words)
        
        rec(0, 0, [])
        return res