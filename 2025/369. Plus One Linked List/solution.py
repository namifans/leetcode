# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def plusOne(self, head: ListNode) -> ListNode:
        def plus(head):
            if not head:
                return 1
            head.val += plus(head.next)
            if head.val >= 10:
                head.val -= 10
                return 1
            return 0
        carry = plus(head)
        if carry: 
            newnode = ListNode(carry)
            newnode.next, head = head, newnode
        return head