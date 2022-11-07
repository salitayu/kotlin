fun twoSum(nums: IntArray, target: Int) {
    var indexLocations : HashMap<Int, Int> = HashMap<Int, Int>();
    for(i in nums.indices) {
        val current = nums[i];
        val diff = target - current;
        if (diff in indexLocations) {
            return intArrayOf(nums[diff]!!, i);
        } else {
            indexLocations.put(current, i);
        }
    }
    return intArrayOf(-1, -1);
}

fun main() {
    println(twoSum(intArrayOf(2, 7, 11, 15)));
}
