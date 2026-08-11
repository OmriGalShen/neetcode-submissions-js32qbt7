class Node:
    def __init__(self) -> None:
        self.children = {}
        self.final = False


class WordDictionary:
    def __init__(self):
        self.head = Node()

    def addWord(self, word: str) -> None:
        curr = self.head
        for c in word:
            if c not in curr.children:
                curr.children[c] = Node()
            curr = curr.children[c]
        curr.final = True

    def search(self, word: str) -> bool:
        def dfs(node, word, i):
            for j in range(i, len(word)):
                c = word[j]
                if c == '.':
                    for child in node.children.values():
                        if dfs(child, word, j+1):
                            return True
                    return False
                if c not in node.children:
                    return False
                node = node.children[c]
                    
            return node.final

        return dfs(self.head, word, 0)

                
