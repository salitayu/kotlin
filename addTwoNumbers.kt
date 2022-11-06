class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class addTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var result : ListNode = ListNode(0);
        var resultRef : ListNode = result;
        var carry : Int = 0;
        var l1copy : ListNode? = l1;
        var l2copy : ListNode? = l2;
        while (l1copy != null || l2copy != null || carry != 0) {
            var x : Int = 0;
            var y : Int = 0;
            if (l1copy != null) {
                x = l1copy.`val`;
            }
            if (l2copy != null) {
                y = l2copy.`val`;
            }
            val temp : Int = x + y + carry;
            result.next = ListNode(temp % 10);
            result = result.next;
            carry = temp / 10;
            if (l1copy != null) {
                l1copy = l1copy.next;
            }
            if (l2copy != null) {
                l2copy = l2copy.next;
            }
        }
        return resultRef.next;
    }
}