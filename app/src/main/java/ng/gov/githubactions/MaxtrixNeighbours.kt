package ng.gov.githubactions

fun main () {
    val arr = arrayOf(
        arrayOf("a", "1", "b", "3", "c", "u"),
        arrayOf("5", "d", "7", "e", "9"),
        arrayOf("10", "11", "f", "g", "12")
    )
//Expected output
//    elem a -> neighbors -> [1, 5, d]
//    elem 1 -> neighbors -> [a, b, 5, d, 7]
//    elem b -> neighbors -> [1, 3, d, 7, e]
//    elem 3 -> neighbors -> [b, c, 7, e, 9]
//    elem c -> neighbors -> [3, u, e, 9]
//    elem u -> neighbors -> [c, 9]
//    elem 5 -> neighbors -> [d, a, 1, 10, 11]
//    elem d -> neighbors -> [5, 7, a, 1, b, 10, 11, f]
//    elem 7 -> neighbors -> [d, e, 1, b, 3, 11, f, g]
//    elem e -> neighbors -> [7, 9, b, 3, c, f, g, 12]
//    elem 9 -> neighbors -> [e, 3, c, u, g, 12]
//    elem 10 -> neighbors -> [11, 5, d]
//    elem 11 -> neighbors -> [10, f, 5, d, 7]
//    elem f -> neighbors -> [11, g, d, 7, e]
//    elem g -> neighbors -> [f, 12, 7, e, 9]
//    elem 12 -> neighbors -> [g, e, 9]

    //methodOne(arr)
    methodTwo(arr)

}
fun methodTwo(arr: Array<Array<String>>) {
    arr.forEachIndexed { edex, elem ->
        elem.forEachIndexed { index, string ->
            val p1 = elem.elementAtOrNull(index - 1)
            val p2 = elem.elementAtOrNull(index + 1)
            val p3 = arr.elementAtOrNull(edex - 1)?.elementAtOrNull(index - 1)
            val p4 = arr.elementAtOrNull(edex - 1)?.elementAtOrNull(index)
            val p5 = arr.elementAtOrNull(edex - 1)?.elementAtOrNull(index + 1)
            val p6 = arr.elementAtOrNull(edex + 1)?.elementAtOrNull(index - 1)
            val p7 = arr.elementAtOrNull(edex + 1)?.elementAtOrNull(index)
            val p8 = arr.elementAtOrNull(edex + 1)?.elementAtOrNull(index + 1)

            val neighbors = arrayOf(p1, p2, p3, p4, p5, p6, p7, p8).filterNotNull()
            println("elem $string -> neighbors -> $neighbors")
        }
    }
}

fun methodOne(arr: Array<Array<String>>) {
    val parentArrSize = arr.size
    var curArrSize = 0
    arr.forEachIndexed { curArrIndex, curArr ->
        val prevArr = curArrIndex - 1
        val nextArr = curArrIndex + 1
        curArr.forEachIndexed { stringIndex, string ->
            val prevNeighbor = stringIndex - 1
            val nextNeighbor = stringIndex + 1

            if (nextArr != arr.size && nextNeighbor != curArr.size && prevArr != -1 && prevNeighbor != -1) {
                println("elem -> $string, neighbors -> ${arr[prevArr][prevNeighbor]} ${arr[prevArr][stringIndex]} ${arr[prevArr][nextNeighbor]} " +
                        "${curArr[prevNeighbor]} ${curArr[nextNeighbor]} " +
                        "${arr[nextArr][prevNeighbor]} ${arr[nextArr][stringIndex]} ${arr[nextArr][nextNeighbor]}"
                )
            } else if (nextArr != arr.size && nextNeighbor != curArr.size && prevArr == -1 && prevNeighbor != -1) {
                println("elem -> $string, neighbors -> ${curArr[prevNeighbor]} ${curArr[nextNeighbor]} " +
                        "${arr[nextArr][prevNeighbor]} ${arr[nextArr][stringIndex]} ${arr[nextArr][nextNeighbor]}"
                )
            } else if (nextArr == arr.size && nextNeighbor != curArr.size && prevArr != -1 && prevNeighbor != -1) {
                println("elem -> $string, neighbors -> ${arr[prevArr][prevNeighbor]} ${arr[prevArr][stringIndex]} ${arr[prevArr][nextNeighbor]} " +
                        "${curArr[prevNeighbor]} ${curArr[nextNeighbor]}"
                )
            } else if (nextArr != arr.size && nextNeighbor != curArr.size && prevArr == -1 && prevNeighbor == -1) {
                println("elem -> $string, neighbors ->${curArr[nextNeighbor]} " +
                        "${arr[nextArr][stringIndex]} ${arr[nextArr][nextNeighbor]}"
                )
            } else if (nextArr == arr.size && nextNeighbor == curArr.size && prevArr != -1 && prevNeighbor != -1) {
                println("elem -> $string, neighbors -> ${arr[prevArr][prevNeighbor]} ${arr[prevArr][stringIndex]} ${curArr[prevNeighbor]}"
                )
            } else if (nextArr != arr.size && nextNeighbor == curArr.size && prevArr == -1 && prevNeighbor != -1) {
                println("elem -> $string, neighbors -> ${curArr[prevNeighbor]} " +
                        "${arr[nextArr][prevNeighbor]} ${arr[nextArr][stringIndex]} "
                )
            } else if (nextArr == arr.size && nextNeighbor != curArr.size && prevArr != -1 && prevNeighbor == -1) {
                println("elem -> $string, neighbors ->  ${arr[prevArr][stringIndex]} ${arr[prevArr][nextNeighbor]} ${curArr[nextNeighbor]} "
                )
            } else if (nextArr != arr.size && nextNeighbor == curArr.size && prevArr != -1 && prevNeighbor != -1) {
                println("elem -> $string, neighbors -> ${arr[prevArr][prevNeighbor]} ${arr[prevArr][stringIndex]} ${curArr[prevNeighbor]} " +
                        "${arr[nextArr][prevNeighbor]} ${arr[nextArr][stringIndex]} "
                )
            } else if (nextArr != arr.size && nextNeighbor != curArr.size && prevArr != -1 && prevNeighbor == -1) {
                println("elem -> $string, neighbors -> ${arr[prevArr][stringIndex]} ${arr[prevArr][nextNeighbor]} ${curArr[nextNeighbor]} " +
                        "${arr[nextArr][stringIndex]} ${arr[nextArr][nextNeighbor]}"
                )
            }

        }
    }
}
