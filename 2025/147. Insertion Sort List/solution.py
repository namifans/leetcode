# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def insertionSortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy, cur = ListNode(), head
        list_array = []
        while cur:
            list_array.append(cur)
            cur = cur.next
            list_array[-1].next = None

        for insert in list_array:
            cur = dummy
            while cur and cur.next and cur.next.val < insert.val:
                cur = cur.next
            cur.next, insert.next = insert, cur.next

        return dummy.next