import java.util.*

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        var isSeeded = false
        println("Length:")
        val length = scanner.nextInt()
        scanner.nextLine()
        println("Form seed? (y/n)")
        if (scanner.nextLine() == "y")
            isSeeded = true;

        var seed : Array<Int> = Array(length){ 0 }

        if (isSeeded){
            println("Seed:")
            for (index in 0 until length) {
                println("S[$index]:")
                seed[index] = scanner.nextInt();
            }
        }

        if (isSeeded)
            Password(seed, length)
        else
            Password(length)

    }

}