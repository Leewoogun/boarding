class FindMax(private val list : List<String>){
    private var maxNumList : MutableList<Int> = mutableListOf()
    fun findMaxNum() : Int{
        var maxLeftList : MutableList<Int> = mutableListOf()
        var temp1 = 0
        var temp2 = 1
        for (i in list[0]){
            temp1 += Character.getNumericValue(i)
        }
        maxLeftList.add(temp1)

        for (i in list[0]){
            temp2 *= Character.getNumericValue(i)
        }
        maxLeftList.add(temp2)

        val leftNum = maxLeftList.max()
        maxNumList.add(leftNum)

        var maxRightList : MutableList<Int> = mutableListOf()
        for (i in list[1]){
            temp1 += Character.getNumericValue(i)
        }
        maxRightList.add(temp1)

        for (i in list[1]){
            temp2 *= Character.getNumericValue(i)
        }
        maxRightList.add(temp2)

        val rightNum = maxRightList.max()
        maxNumList.add(rightNum)

        return maxNumList.max()
    }
}