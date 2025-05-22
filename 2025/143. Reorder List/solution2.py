# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        # slow fast find middle
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # reverse half list
        prev, slow = slow, slow.next
        while slow and slow.next: 
            tmp, tmp2 = prev.next, slow.next.next
            prev.next = slow.next
            slow.next.next = tmp
            slow.next = tmp2

        # merge two half lists
        slow, fast = head, prev.next
        prev.next = None
        while slow and fast:
            tmp, tmp2 = slow.next, fast.next
            slow.next = fast
            fast.next = tmp
            slow = fast.next
            fast = tmp2