# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def insertionSortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy, cur = ListNode(), head
        while cur:
            node = cur
            cur = cur.next
            node.next = None
            insert = dummy
            while insert and insert.next and insert.next.val < node.val:
                insert = insert.next
            insert.next, node.next = node, insert.next
        return dummy.next