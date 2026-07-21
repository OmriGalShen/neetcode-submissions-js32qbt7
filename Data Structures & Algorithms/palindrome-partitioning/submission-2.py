class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []

        def is_palindrome(s):
            for i in range(len(s)//2):
                if s[i] != s[-i-1]:
                    return False
            return True

        def rec(l, r, lst):
            if l == len(s):
                res.append(lst[::])
                return
            if r >= len(s):
                return 
            sub = s[l:r+1]
            if is_palindrome(sub):
                lst.append(sub)
                rec(r+1, r+1, lst)
                lst.pop()
            rec(l, r+1, lst)

        rec(0, 0, [])

        return res
