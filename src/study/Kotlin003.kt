package stud

import java.lang.Thread.sleep


/**
 * kotlin线程
 */

fun main(args: Array<String>) {

    //集成Thread类
//    object : Thread() {
//        override fun run() {
//            var i = 1
//            while (i < 10) {
//                println(i)
//                sleep(300L)
//                i++
//            }
//        }
//    }.start()

//    Thread(object : Runnable {
//        override fun run() {
//            var i = 1
//            while (i < 10) {
//                println(i)
//                sleep(300L)
//                i++
//            }
//        }
//    }).start()

    var num = Num()
    var obj = java.lang.Object()

    var odd = object : Runnable {
        override fun run() {
            while (num.i < 10) {
                synchronized(obj) {
                    if (num.flag) {
                        println(Thread.currentThread().name + "  " + num.i)
                        num.i++
                        num.flag = false
                        sleep(300L)
                        obj.notifyAll()
                    } else {
                        obj.wait()
                    }
                }
            }
        }
    }
    var eve = object : Runnable {
        override fun run() {
            while (num.i < 10) {
                synchronized(obj) {
                    if (!num.flag) {
                        println(Thread.currentThread().name + "  " + num.i)
                        num.i++
                        num.flag = true
                        sleep(300L)
                        obj.notifyAll()
                    } else {
                        obj.wait()
                    }
                }
            }
        }
    }

    Thread(odd).start()
    Thread(eve).start()
}

class Num {
    var i = 1
    var flag = false
}


