import java.io.File
import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.*

class Password {

    val dictionary = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"

    fun seededRandomInt(min: Int, max: Int, seed: Int): Int {

        val random = Random()
        random.setSeed(seed.toLong())
        return random.nextInt(max - min) + min
    }

    private var password = ""


    private fun randomInt(min: Int, max: Int): Int {

        val random = Random()
        return random.nextInt(max - min) + min
    }

    constructor(seed: Array<Int>, length: Int) {

        var seedIndex = 0;

        for (index in 0 until length) {
            password += dictionary[seededRandomInt(0, dictionary.length, seed[seedIndex])]
            seedIndex++
            if (seedIndex == seed.size)
                seedIndex = 0
        }


        println("PASS: $password L: ${password.length} S: ${seed.contentToString()}")

        val date = Date()
        val dateParser = SimpleDateFormat("hh-mm-ss_dd-MM-yyyy")
        val dataString = dateParser.format(date)

        val file = File("$password $dataString.txt")
        file.createNewFile();
        val fileWriter = FileWriter(file)
        fileWriter.write("$password\n")
        fileWriter.write("$length\n")
        for (item in seed)
            fileWriter.write("$item\n")
        fileWriter.close()
        println("Saved to $password $dataString.txt")


    }

    constructor(length: Int) {
        var seed: Array<Int> = Array(length) { 0 }
        for (seedIndex in 0 until length) {
            seed[seedIndex] = randomInt(0, 65535)
        }
        Password(seed, length)

    }


}