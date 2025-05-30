# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class HeapNode:
    def __init__(self, node):
        self.node = node

    def __lt__(self, other):
        return self.node.val < other.node.val

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = [HeapNode(node) for node in lists if node is not None]
        heapq.heapify(heap)
        dummy = head = ListNode()
        while heap:
            node = heapq.heappop(heap).node
            if node.next:
                heapq.heappush(heap, HeapNode(node.next))
                node.next = None
            head.next = node
            head = head.next
        return dummy.next