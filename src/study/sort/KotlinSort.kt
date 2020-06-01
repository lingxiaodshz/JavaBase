package study.sort

import com.sun.xml.internal.fastinfoset.util.StringArray

fun main(args: Array<String>) {

}

fun bubbleSort(nums: IntArray) {
    for (i in 0..nums.size - 2) {
        for (j in 0..nums.size - 2 - i) {
            if (nums[j] > nums[j + 1]) {
                swap(j, j + 1, nums)
            }
        }
    }
}

fun selectSort(nums: IntArray) {
    var index = 0;
    for (i in 0 until nums.size) {
        index = 0
        for (j in 0 until nums.size - i) {
            if (nums[j] > nums[index]) {
                index = j
            }
        }
        swap(index, nums.size - i - 1, nums)
    }

}

fun shellSort(nums: IntArray) {
    var gap = nums.size / 2
    while (gap > 0) {
        for (i in 0 until nums.size - gap step gap) {
            if (nums[i] > nums[i + gap]) {
                var index = i + gap
                while (index - gap >= 0 && nums[index - gap] > nums[index]) {
                    swap(index-gap, index, nums)
                    index -= gap
                }
            }
        }
        gap /= 2
    }
}

fun fastSort(nums: IntArray, left: Int, right: Int) {
    if (left >= right) {
        return
    }
    var L=left
    var R=right
    var temp = nums[L]
    while (L < R) {
        while (L < R && nums[R] >= temp) {
            R--;
        }
        if (L < R) {
            nums[L] = nums[R]
        }
        while (L < R && nums[L] <= temp) {
            L++;
        }
        if (L < R) {
            nums[R] = nums[L]
        }
    }
    nums[L] = temp

    fastSort(nums, left, L - 1)
    fastSort(nums, L + 1, right)

}

fun insertSort(nums: IntArray) {
    for (i in 1 until nums.size) {
        var index = i
        while (index > 0 && nums[index] <= nums[index - 1]) {
            swap(index, index - 1, nums)
            index--
        }
    }
}

fun heapSort(nums: IntArray) {
    for (i in nums.size / 2 - 1 downTo 0) {
        buildHeap(nums, nums.size, i)
    }

    for (i in nums.size - 1 downTo 1) {
        swap(0, i, nums)
        buildHeap(nums, i, 0)
    }

}

fun buildHeap(nums: IntArray, len: Int, k: Int) {
    var j = k
    var i = 2 * j + 1
    while (i < len) {
        if (i + 1 < len && nums[i + 1] > nums[i]) {
            i++
        }
        if (nums[i] > nums[j]) {
            swap(j, i, nums)
            j = i
            i = 2 * j + 1
        } else {
            break
        }
    }
}

private fun swap(a: Int, b: Int, nums: IntArray) {
    var temp = nums[a]
    nums[a] = nums[b]
    nums[b] = temp
}