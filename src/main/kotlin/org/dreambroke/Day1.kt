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
            var i = 0
            var j = line.length - 1
            var isFirstFound = false
            var isLastFound = false
            while (i <= j) {
                val ci = line[i]
                val cj = line[j]
                if (ci.isDigit()) {
                    isFirstFound = true
                }
                if (cj.isDigit()) {
                    isLastFound = true
                }
                if (isFirstFound && isLastFound) {
                    sum += Integer.parseInt(ci + "" + cj)
                    break
                }
                if (!isFirstFound) {
                    i++
                }
                if (!isLastFound) {
                    j--
                }
            }
        }
        return sum.toString()
    }

    override fun partB(input: String): String {
        val digitsInWords = mapOf("one" to 1, "two" to 2, "three" to 3, "four" to 4, "five" to 5, "six" to 6, "seven" to 7, "eight" to 8, "nine" to 9)
        val lines = Utils.splitStringByLine(input)
        var sum = 0
        for (line in lines) {
            var i = 0
            var j = line.length - 1
            var first: String? = null
            var last: String? = null
            while (i <= j) {
                if (first == null) {
                    for (ie in 1 .. 5) {
                        val str = line.substring(i, i + ie)
                        if (str.isInt()) {
                            first = str
                            break
                        }
                        if (digitsInWords.keys.any { it.startsWith(str) }) {
                            val firstFind = digitsInWords.keys.find { it == str }
                            if (firstFind != null) {
                                first = digitsInWords[firstFind].toString()
                            } else {
                                continue
                            }
                        } else {
                            break
                        }
                    }
                }
                if (last == null) {
                    for (js in 1 .. 5) {
                        val str = line.substring(j - js + 1, j + 1)
                        if (str.isInt()) {
                            last = str
                            break
                        }
                        if (digitsInWords.keys.any { it.endsWith(str) }) {
                            val lastFind = digitsInWords.keys.find { it == str }
                            if (lastFind != null) {
                                last = digitsInWords[lastFind].toString()
                            } else {
                                continue
                            }
                        } else {
                            break
                        }
                    }
                }
                if (first != null && last != null) {
                    sum += Integer.parseInt(first + "" + last)
                    break
                }
                if (first == null) {
                    i++
                }
                if (last == null) {
                    j--
                }
            }
        }
        return sum.toString()
    }

    private fun String.isInt(): Boolean {
        return try {
            this.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }
}
