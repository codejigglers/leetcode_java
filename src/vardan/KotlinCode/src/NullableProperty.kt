


fun main(args: Array<String>) {
    var a : String = "vardan"

    //We cannot assign a null value to this string. If we still want to assign a null value to this string, we will need to add ? in front of String.
    //a = null   # Throws the error

    var b : String? = "Gupta"

    b = null

    var m : String? = null



    //checkForNull(m)   # This will throw an error since this method is accepting non nullable variable
}


fun checkForNull(v : String) {

    //Here we dont have to do the null check, because we have not added question mark in front of String
    // We can directly use it because it can never be null

     var a : IntArray = IntArray(10)
    print(a[0])


}