package ng.gov.githubactions

fun main() {

    intervalIntersection(
        arrayOf(intArrayOf(0, 2), intArrayOf(5, 10), intArrayOf(13, 23), intArrayOf(24, 25)),
        arrayOf(intArrayOf(1, 5), intArrayOf(8, 12), intArrayOf(15, 24), intArrayOf(25, 26))
    )
//Expected Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

}

fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
    val firstIntervals = firstList.map { list ->
        (list[0]..list[1]).toList()
    }
    val secondIntervals = secondList.map { list ->
        (list[0]..list[1]).toList()
    }
    var intersectedIntervals = arrayOf<IntArray>()

    firstIntervals.forEach { aList ->
        secondIntervals.forEach { bList ->
            val iList = aList.intersect(bList)
            if (iList.isNotEmpty()) {
                val min = iList.first()
                val max = iList.last()
                intersectedIntervals = intersectedIntervals.plus(intArrayOf(min, max))
            }
        }
    }
    return intersectedIntervals
}