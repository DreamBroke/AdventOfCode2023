package org.dreambroke

object Utils {
    fun splitStringByLine(input: String): List<String> {
        return input.split(System.lineSeparator())
    }
}