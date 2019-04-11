
//We use typealias so that we can assign some literal meanings to datastructures. Its just renaming of datastructures, rest of the things will remain same as that
//of data stucture.

typealias vardan = String

object SingletonObject {

    var a : String = "Vardan"

}


fun main(args: Array<String>) {

    val v : vardan

    print(SingletonObject.a)
    SingletonObject.a = "Gupta"
    print(SingletonObject.a)
}