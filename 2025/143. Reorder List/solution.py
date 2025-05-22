# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        list = []
        dummy = ListNode()
        cur = dummy
        while head:
            list.append(head)
            head = head.next
        for i in range(math.ceil(len(list)/2)):
            node = list[i]
            next_node = list[-(i+1)]
            tmp = node.next
            cur.next = node
            node.next = next_node
            next_node.next = None
            if cur.next:
                cur = cur.next.next
        return dummy.next