fun makeGood(s: String): String {
    var stack = ArrayDeque<Int>();
    var ans = StringBuilder();
    for (i in s.indices) {
        val curr = s[i].toInt();
        if (!stack.isEmpty() && (stack.peek() - curr == 32 || curr - stack.peek() == 32)) {
            stack.pop();
        } else {
            stack.push(curr);
        }
    }
    for(i in stack.reversed()) {
        ans.append(i.toChar());
    }
    return ans;
}