package day03

import (
	"aoc2021go/utils"
	"fmt"
	"strconv"
)

func Task01() {
	var data = utils.ReadFileAsStrings("day03/data_01")
	var cols = make([][]int64, len(data[0]))
	for i := range cols {
		cols[i] = make([]int64, len(data))
	}
	for row, line := range data {
		for charidx, char := range line {
			var current, _ = strconv.ParseInt(string(char), 10, 64)
			cols[charidx][row] = current
		}
	}
	var gamma = ""
	var epsilon = ""
	for _, col := range cols {
		var ones int64 = 0
		for _, r := range col {
			ones += r
		}
		if ones > int64(len(col)/2) {
			gamma += "1"
			epsilon += "0"
		} else {
			gamma += "0"
			epsilon += "1"
		}
	}
	fmt.Println(parse(gamma) * parse(epsilon))
}

func Task02() {

}

func parse(binaryString string) int64 {
	res, _ := strconv.ParseInt(binaryString, 2, 64)
	return res
}
