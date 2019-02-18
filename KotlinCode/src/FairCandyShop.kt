fun main(args: Array<String>) {
    var v : RobotReturnOrigin = RobotReturnOrigin()

    var a : IntArray = IntArray(2)
    a[0] = 1
    a[1] = 1

    var b : IntArray = IntArray(2)

    b[0] = 2
    b[1] = 2

}
class Solution {



    fun fairCandySwap(A: IntArray, B: IntArray): IntArray {

        var Sa = 0
        var Sb = 0

        var ans : IntArray = IntArray(2)

        var hashSet2 : HashSet<Int> = HashSet()

        for(i : Int in A) {
            Sa += i
        }

        for(i : Int in B) {
            Sb += i
            hashSet2.add(i)
        }

        for (x in A) {
            if (x + (Sb - Sa) / 2 in hashSet2) {
                var f : IntArray = IntArray(2)
                f[0] = x
                f[1] = x + (Sb - Sa) / 2
                return f
            }

        }

        return ans
    }
}