fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val x : Int = nums1.size;
    val y : Int = nums2.size;
    if (x > y) {
        return findMedian(nums2, nums1)
    }
    return findMedian(nums1, nums2);
}

fun findMedian(nums1: IntArray, nums2: IntArray): Double {
    val x = nums1.size;
    val y = nums2.size;
    var start = 0;
    var end = x;

    while(start <= end) {
        val partitionX = (start + end) / 2;
        val partitionY = (x + y + 1) / 2 - partitionX;
        var maxLeftX = Int.MIN_VALUE;
        var maxLeftY = Int.MIN_VALUE;
        var minRightX = Int.MAX_VALUE;
        var minRightY = Int.MAX_VALUE;
        if (partitionX > 0) {
            maxLeftX = nums1[partitionX - 1];
        }
        if (partitionY > 0) {
            maxLeftY = nums2[partitionY - 1];
        }
        if (partitionX != x) {
            minRightX = nums1[partitionX];
        }
        if (partitionY != y) {
            minRightY = nums2[partitionY];
        }
        if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
            if ((x + y) % 2 == 0) {
                return (maxOf(maxLeftX, maxLeftY) + minOf(minRightX, minRightY).toDouble()) / 2;
            } else {
                return maxOf(maxLeftX, maxLeftY).toDouble();
            }
        } else if (maxLeftX > minRightY) {
            end = partitionX - 1;
        } else {
            start = partitionX + 1;
        }
    }
    return 0.0;
}

fun main() {
    println("medianOfTwoSortedArrays");
}
