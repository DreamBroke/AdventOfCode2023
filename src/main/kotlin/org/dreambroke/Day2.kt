package org.dreambroke

object Day2 : BaseProblem() {
    @JvmStatic
    fun main(args: Array<String>) {
        solvePartA()
        solvePartB()
    }

    override fun partA(input: String): String {
        val lines = Utils.splitStringByLine(input)
        var result = 0
        for (line in lines) {
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
            if (maxBlueCubesCount <= 14 && maxGreenCubesCount <= 13 && maxRedCubesCount <= 12) {
                val gameId = line.substringBefore(":").trim().split(" ")[1].toInt()
                result += gameId
            }
        }
        return result.toString()
    }

    override fun partB(input: String): String {
        return ""
    }
}
