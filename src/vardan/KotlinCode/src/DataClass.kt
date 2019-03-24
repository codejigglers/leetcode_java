
//If we create a class in this way, we don't need any getter or setter, constructors or getString and various other methods.
data class DataClass(var name : String, val id : Int) {


}


fun main(args : Array<String>) {
    val instance = DataClass("Vardan", 2);

    instance.id;

    //Multiple assignments also work with the data classes as follows:

    var(abc, def) = DataClass("Vardan", 23)

    print(abc)
}