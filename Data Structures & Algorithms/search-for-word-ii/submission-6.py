class Node:
    def __init__(self) -> None:
        self.children = {}
        self.word = ''

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        res = []
        head = Node()
        N, M = len(board), len(board[0])
        for word in words:
            curr = head
            for c in word:
                if c not in curr.children:
                    curr.children[c] = Node()
                curr = curr.children[c]
            curr.word = word
        def dfs(row, col, node):
            if row < 0 or col < 0 or row >= N or col >= M:
                return
            c = board[row][col]
            if c == '#' or c not in node.children:
                return
            board[row][col] = '#'
            node = node.children[c]
            if node.word:
                res.append(node.word)
                node.word = ''
            dfs(row +1, col, node)
            dfs(row, col+1, node)
            dfs(row -1, col, node)
            dfs(row, col-1, node)
            board[row][col] = c
        
        for row in range(N):
            for col in range(M):
                dfs(row,col, head)
        return res



        