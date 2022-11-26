fun main(args: Array<String>) {
    for (i in 0..2){
        val result = solution1()
        println(result)
    }
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

