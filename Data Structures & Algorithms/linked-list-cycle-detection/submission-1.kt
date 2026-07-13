class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head?.next

        while (fast?.next != null && fast?.next?.next != null) {
            if (slow?.`val` == fast.`val`) {
                return true
            }
            slow = slow?.next
            fast = fast?.next?.next
        }

        return false
    }
}