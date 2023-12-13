package org.dreambroke

object Day2 : BaseProblem() {

    data class CubeCounts(val red: Int, val green: Int, val blue: Int)

    private fun handleLine(line: String, action: (CubeCounts) -> Unit) {
        val cubesGroupStr = line.substringAfter(":").trim()
        val cubesGroup = cubesGroupStr.split(";")
        var maxRedCubesCount = 0
        var maxGreenCubesCount = 0
        var maxBlueCubesCount = 0
        for (cubes in cubesGroup) {
            val singleCubeList = cubes.split(",")
            for (cube in singleCubeList) {
                val singleCube = cube.trim().split(" ")
                val count = singleCube[0].toInt()
                val color = singleCube[1]
                when (color) {
                    "red" -> if (count > maxRedCubesCount) maxRedCubesCount = count
                    "green" -> if (count > maxGreenCubesCount) maxGreenCubesCount = count
                    "blue" -> if (count > maxBlueCubesCount) maxBlueCubesCount = count
                }
            }
        }
        action(CubeCounts(maxRedCubesCount, maxGreenCubesCount, maxBlueCubesCount))
    }

    @JvmStatic
    fun main(args: Array<String>) {
        solvePartA()
        solvePartB()
    }

    override fun partA(input: String): String {
        val totalBlueCubes = 14
        val totalGreenCubes = 13
        val totalRedCubes = 12
        val lines = Utils.splitStringByLine(input)
        var result = 0
        for (line in lines) {
            handleLine(line) { cubeCounts ->
                if (cubeCounts.blue <= totalBlueCubes && cubeCounts.green <= totalGreenCubes && cubeCounts.red <= totalRedCubes) {
                    val gameId = line.substringBefore(":").trim().split(" ")[1].toInt()
                    result += gameId
                }
            }
        }
        return result.toString()
    }

    override fun partB(input: String): String {
        val lines = Utils.splitStringByLine(input)
        var result = 0
        for (line in lines) {
            handleLine(line) { cubeCounts ->
                result += cubeCounts.blue * cubeCounts.green * cubeCounts.red
            }
        }
        return result.toString()
    }
}