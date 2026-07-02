/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return head
        var curr = head
        var next = curr.next
        curr.next = null

        while (next != null) {
            val newNext = next.next
            next.next = curr
            curr = next
            next = newNext
        }

        return curr
    }
}
