class Node:
    def __init__(self) -> None:
        self.childern = {}
        self.final = False

class WordDictionary:

    def __init__(self):
        self.head = Node()

    def addWord(self, word: str) -> None:
        curr = self.head
        for c in word:
            if c not in curr.childern:
                curr.childern[c] = Node()  
            curr = curr.childern[c]
        curr.final = True

    def search(self, word: str) -> bool:
        return self._search(self.head, word,0)

    def _search(self, node, word, start_i):
        curr = node
        for i in range(start_i, len(word)):
            c = word[i]
            if c == '.':
                for child in curr.childern.values():
                    if self._search(child, word, i+1):
                        return True
                return False
            elif c in curr.childern:
                curr = curr.childern[c]
            else:
                return False
        return curr.final
            
        
