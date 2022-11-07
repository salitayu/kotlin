fun longestSubstringWithoutRepeatingCharacters(s: String) {
    var start: Int = 0;
    var maxlen: Int = 0;
    var counts: HashMap<Char, Int> = HashMap<Char, Int>();
    for(end in s.indices) {
        val curr = s[end];
        if (curr in counts) {
            start = maxOf(counts[curr]!! + 1, start);
        }
        counts[curr] = end;
        maxlen = maxOf(maxlen, end - start + 1);
    }
    return maxlen;
}

fun main() {
    println(longestSubstringWithoutRepeatingCharacters("abcabc"));
}
