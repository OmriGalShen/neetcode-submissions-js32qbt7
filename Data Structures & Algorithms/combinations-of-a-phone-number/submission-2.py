class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []
        res = []
        mapping = {
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": "wxyz",
        }
        def rec(i, l):
            if len(l) == len(digits):
                res.append(''.join(l))
                return
            latters = mapping[digits[i]]
            for latter in latters:
                l.append(latter)
                rec(i+1, l)
                l.pop()

        rec(0, [])
        return res