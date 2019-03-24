class RobotReturnOrigin {
    fun judgeCircle(moves: String): Boolean {

        var a : HashMap<Char, IntArray> = HashMap();
        a.put('U', intArrayOf(0, 1));
        a.put('D', intArrayOf(0, -1));
        a.put('L', intArrayOf(-1, 0));
        a.put('R', intArrayOf(1,0));

        var x : Int = 0
        var y = 0

        for(m : Char in moves) {
            x = x + (a.get(m)?.get(0)!!)
            y= y+(a.get(m)?.get(0)!!)
        }

        if(x.equals(0) && y.equals(0)) {
            return true;
        }
        return false;

    }
}

fun main(args: Array<String>) {
    var a : RobotReturnOrigin = RobotReturnOrigin()
    a.judgeCircle("DURDLDRRLL")
}