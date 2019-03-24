


fun main(args : Array<String>) {
    println("Hello World!!")

    print(sum(2, 3))
    overloadedMethod("ca")

    //For assigning multiple values in a single line, we can use pair and directly assign it.
    var(name, email) = howToReturnFromMethod("DD")
}

//We can declare a function like this as well. Equals sign represents return statement.
fun sum(x : Int, y : Int) = x + y


//We can basically overload a method by passing in a default value of arguement in the method itself
//We don't need to create same method multiple times with different arguments.
fun overloadedMethod(a : String, b: String = "") {
    print("$a $b")
}


//This is how we return some values in Kotlin from a method
fun howToReturnFromMethod(v: String) : Pair<String, String> {
    return Pair("Vardan", "Gupta")
}





