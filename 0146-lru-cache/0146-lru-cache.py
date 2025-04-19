class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.head = Node(-1, -1)
        self.tail = Node(-1,-1)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.map = {}
    

    def get(self, key: int) -> int:
        if key in self.map:
            node = self.map[key]
            self.deleteNode(node)
            self.addNode(node)
            return node.value

        return -1    
        

    def put(self, key: int, value: int) -> None:
        if key in self.map:
            node = self.map[key]
            new_node = Node(key, value)
            self.deleteNode(node)
            self.addNode(new_node)
            self.map[key] = new_node   
        else:
            if len(self.map) == self.capacity:
                evict = self.tail.prev
                self.deleteNode(evict)
                del self.map[evict.key]
                
            new_node = Node(key, value)
            self.addNode(new_node)
            self.map[new_node.key] = new_node    


    # add always to the front
    def addNode(self, node):
        curr_head_next = self.head.next
        self.head.next = node
        node.prev = self.head
        node.next = curr_head_next
        curr_head_next.prev = node

    # delete happens from the last
    def deleteNode(self, node):
        prev_node = node.prev
        next_node = node.next
        prev_node.next = next_node
        next_node.prev = prev_node
        

class Node:

    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None
    

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)