import java.util.*

fun main(args: Array<String>) {
    for (i in 0..2){
        val result1 = solution1()
        println(result1)
    }
    val result2 = solution2()
    println(result2)
}

fun solution1() : Int{
    val pobi = readLine()!!.split(" ")
    val crong = readLine()!!.split(" ")
    val pobiScore = FindMax(pobi).findMaxNum()
    val crongScore = FindMax(crong).findMaxNum()

    if (pobi[1].toInt() - pobi[0].toInt() > 1 || crong[1].toInt() - crong[0].toInt() > 1){
        return -1
    }

    if (pobiScore > crongScore){
        return 1
    }
    else if (pobiScore < crongScore){
        return 2
    }
    else return 0
}

fun solution2() : String{
    val input = readLine()
    val stack = Stack<Char>()
    var result = ""

    for (i in input!!){

        if (stack.isEmpty()){
            stack.add(i)
            continue
        }

        if (stack.peek() == i){
            stack.pop()
        }
        else stack.push(i)
    }

    for (i in stack){
        result += i
    }
    return result
}

