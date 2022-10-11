import java.io.File
import java.util.*

fun main() {
 val mp = mutableSetOf<String>("hello", "world")
 mp.remove("hello")
 println(mp)

}

//fun tf(args: String) = args.split('/')