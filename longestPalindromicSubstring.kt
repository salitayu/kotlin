fun longestPalindrome(s: String): String {
    var center = 0;
    var right = 0;
    var temp = intArrayOf("$");
    for (i in s.indices){
        temp += "#";
        temp += s[i];
    }
    temp += "#";
    temp += "@";
    var p = IntArray();
    for (var i in temp) {
        p += 0;
    }
    for (i in temp.indices) {
        val middle = 2 * center - i;
        if (i < right) {
            p[i] = minOf(right - i, p[middle]);
            while(temp[i + (1 + p[i])] == temp[i - (1 + p[i])]) {
                p[i] = p[i] + 1;
            } 
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }
    }
    var maxlen = maxOf(p);
    val index = p.indexOfFirst(maxlen);
    var result = "";
    for (i in index-maxlen..index+maxlen) {
        if (temp[i] != "$" && temp[i] != "#" && temp[i] != "@") {
            result += temp[i];
        }
    }
    return result;
}

fun main() {
    println(longestPalindrome("aba"));
}