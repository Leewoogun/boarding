import java.util.*

fun main(args: Array<String>) {
//    for (i in 0..2){
//        val result1 = solution1()
//        println(result1)
//    }
//    val result2 = solution2("browoanoommnaon")
//    println(result2)
//    print(solution3(33))\
//    print(solution4("I love you"))
//    print(solution5(50237))
    val input = arrayListOf(arrayListOf("jm@email.com", "제이엠"), arrayListOf("jason@email.com", "제이슨"), arrayListOf("woniee@email.com", "워니")
        , arrayListOf("mj@email.com", "엠제이"), arrayListOf("nowm@email.com", "이제엠"))
    print(solution6(input))
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

fun solution2(input : String) : String{
    val stack = Stack<Char>()
    var result = ""

    for (i in input){

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

fun solution3(number : Int) :Int {
    var clap = 0

    for (i in 1..number) {
        val num = i.toString()
        for (j in num) {
            if (j == '3' || j == '6'|| j == '9'){
                clap += 1
            }
        }
    }

    return clap
}

fun solution4(word : String): String{
    val alpha = "abcdefghijklmnopqrstuvwxyz" // 0 ~ 25

    var result = ""

    for ((idx, value) in word.withIndex()){
        if (value.isUpperCase()){
            result += alpha[25- alpha.indexOf(value.lowercaseChar())].uppercaseChar()
        }
        else if (value.isLowerCase()){
            result += alpha[25 - alpha.indexOf(value)]
        }
        else result += value
    }

    return result
}

fun solution5(money : Int) : MutableList<Int> {
    var result : MutableList<Int> = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
    val moneyList = arrayOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var money2 = money

    for ((idx, value) in moneyList.withIndex()){
        if (money2 - value >= 0){
            result[idx] = money2 / value
            money2 -= (money2 / value) * value
        }
        else continue
    }

    return result
}

fun solution6(email : ArrayList<ArrayList<String>>) : List<String>{
    val checkList = mutableListOf<String>()
    var emailList = mutableListOf<String>()

    for (i in email) {
        if (i[0].split("@")[1] == "email.com"){
            checkList.add(i[1])
            emailList.add(i[0])
        }
    }
    val result = checkName(checkList, emailList).toMutableSet().sorted().toList()
    return result

}

fun checkName(checkList : MutableList<String>, emailList : MutableList<String>) : MutableList<String>{
    var resultList = mutableListOf<String>()

    for (i in 0 until checkList.size - 1){
        for (j in i+1 until checkList.size){
            for(k in 0 until checkList[i].length - 1){
                var start = 0
                if (checkList[j].contains(checkList[i].slice(start..start+1))){
                    resultList.add(emailList[i])
                    resultList.add(emailList[j])
                    break
                }
                else start += 1
            }
        }
    }

    return resultList


}





