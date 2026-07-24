class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        if not matchsticks:
            return True
        total = sum(matchsticks)
        if total % 4 != 0:
            return False
        w = total//4
        matchsticks.sort(reverse=True)

        sides = [0,0,0,0]
        def rec(i):
            if i == len(matchsticks):
                return True
            for side in range(4):
                if sides[side] + matchsticks[i] <= w:
                    sides[side] += matchsticks[i]
                    if rec(i+1):
                        return True
                    sides[side] -= matchsticks[i]
            
            return False

        return rec(0)