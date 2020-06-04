package study

import java.lang.StringBuilder


fun main(args: Array<String>) {

//    var i = {x:Int, y: Int -> x + y}
//
//    println(i(2,3))

//    for (i in 0 until 9) {
//        println(i)
//    }

//    var range:IntRange = 2 until 10
//    for ((i,e) in range.withIndex()) {
//        println()
//    }


    var num1: Int = "12" as Int
    println(num1)
}

class Solution {
    fun sumNums(n: Int): Int {
        var sum = n
        var i = {x:Int,y:Int->x+y}
//        var flag = (n>0 && (i(sum, sumNums(n-1))>0))
        val flag = n > 0 && sumNums(n - 1).let { sum += it; sum } > 0
        return sum
    }
}