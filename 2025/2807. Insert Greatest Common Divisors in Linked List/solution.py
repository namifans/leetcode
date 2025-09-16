# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def insertGreatestCommonDivisors(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        prev, cur = head, head.next
        while cur:
            divNode = ListNode(math.gcd(prev.val, cur.val))
            divNode.next = cur
            prev.next = divNode
            prev = cur
            cur = cur.next
        return head