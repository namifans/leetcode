class LRUNode:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

class LRUCache:

    def __init__(self, capacity: int):
        self.count = 0
        self.capacity = capacity
        self.key_map = {}
        self.head, self.tail = LRUNode(-1, -1), LRUNode(-1, -1)
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key: int) -> int:
        if key not in self.key_map:
            return -1
        node = self.key_map[key]
        self._move_node(node)
        return node.value

    def put(self, key: int, value: int) -> None:
        if key not in self.key_map:
            node = LRUNode(key, value)
            self.key_map[key] = node
            self.count += 1
            self._add_node(node)
            if self.count > self.capacity:
                self.evict()
        else:
            node = self.key_map[key]
            node.value = value    
            self._move_node(node)

    def evict(self) -> None:
        remove_node = self.tail.prev
        remove_node.prev.next, self.tail.prev = self.tail, remove_node.prev
        del self.key_map[remove_node.key]
        del remove_node

    def _add_node(self, node) -> None:
        node.next, self.head.next.prev = self.head.next, node
        self.head.next, node.prev = node, self.head

    def _move_node(self, node) -> None:
        node.prev.next, node.next.prev = node.next, node.prev
        self._add_node(node)
        
# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)