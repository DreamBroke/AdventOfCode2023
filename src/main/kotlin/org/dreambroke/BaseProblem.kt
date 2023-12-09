package org.dreambroke

abstract class BaseProblem {
    private val inputFile: String

    init {
        val className = this::class.simpleName
        inputFile = "/$className-input.txt"
    }

    private fun readInput(inputResource: String): String {
        return javaClass.getResource(inputResource)?.readText() ?: ""
    }

    fun solvePartA() {
        val input = readInput(inputFile)
        val output = partA(input)
        println(output)
    }

    fun solvePartB() {
        val input = readInput(inputFile)
        val output = partB(input)
        println(output)
    }

    protected abstract fun partA(input: String): String
    protected abstract fun partB(input: String): String
}