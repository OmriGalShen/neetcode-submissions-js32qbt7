class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []

        def rec(l, r, lst):
            if l == len(s):
                res.append(lst[::])
                return
            if r >= len(s):
                return 
            sub = s[l:r+1]
            if sub == sub[::-1]:
                lst.append(sub)
                rec(r+1, r+1, lst)
                lst.pop()
            rec(l, r+1, lst)

        rec(0, 0, [])

        return res
