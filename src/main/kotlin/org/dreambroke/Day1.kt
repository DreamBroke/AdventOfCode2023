package org.dreambroke

object Day1 : BaseProblem() {
    @JvmStatic
    fun main(args: Array<String>) {
        solvePartA()
        solvePartB()
    }

    override fun partA(input: String): String {
        val lines = Utils.splitStringByLine(input)
        var sum = 0
        for (line in lines) {
            val (first, last) = findFirstAndLastDigits(line, null)
            if (first != null && last != null) {
                sum += (first + last).toInt()
            }
        }

        return sum.toString()
    }

    override fun partB(input: String): String {
        val lines = Utils.splitStringByLine(input)
        val digitsInWords = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        var sum = 0
        for (line in lines) {
            val (first, last) = findFirstAndLastDigits(line, digitsInWords)
            if (first != null && last != null) {
                sum += (first + last).toInt()
            }
        }

        return sum.toString()
    }

    private fun findFirstAndLastDigits(line: String, digitsInWords: List<String>?): Pair<String?, String?> {
        var i = 0
        var j = line.length - 1
        var first: String? = null
        var last: String? = null

        while (i <= j) {
            if (first == null) {
                first = if (line[i].isDigit()) line[i].toString()
                else if (digitsInWords != null && line.substring(i).startsWithAny(digitsInWords))
                    digitsInWords.find { line.substring(i).startsWith(it) }?.let { (digitsInWords.indexOf(it) + 1).toString() }
                else null
            }

            if (last == null) {
                last = if (line[j].isDigit()) line[j].toString()
                else if (digitsInWords != null && line.substring(0, j + 1).endsWithAny(digitsInWords))
                    digitsInWords.find { line.substring(0, j + 1).endsWith(it) }?.let { (digitsInWords.indexOf(it) + 1).toString() }
                else null
            }

            if (first != null && last != null) return Pair(first, last)
            if (first == null) i++
            if (last == null) j--
        }

        return Pair(null, null)
    }

    private fun String.startsWithAny(list: List<String>) = list.any { this.startsWith(it) }

    private fun String.endsWithAny(list: List<String>) = list.any { this.endsWith(it) }
}
