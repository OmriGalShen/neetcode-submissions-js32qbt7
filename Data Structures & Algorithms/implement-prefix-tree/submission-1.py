class Node:
    def __init__(self) -> None:
        self.childern = {}
        self.final = False

class PrefixTree:
    def __init__(self):
        self.head = Node()

    def insert(self, word: str) -> None:
        curr = self.head
        for ch in word:
            if ch not in curr.childern:
                curr.childern[ch] = Node()
            curr = curr.childern[ch]
        curr.final = True

    def search(self, word: str) -> bool:
        curr = self.head
        for ch in word:
            if ch not in curr.childern:
                return False
            curr = curr.childern[ch]
        return curr.final

    def startsWith(self, prefix: str) -> bool:
        curr = self.head
        for ch in prefix:
            if ch not in curr.childern:
                return False
            curr = curr.childern[ch]
        return True
