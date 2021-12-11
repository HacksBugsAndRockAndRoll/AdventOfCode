package day01

import (
	"aoc2021go/utils"
	"fmt"
)

func Task01() {
	var data = utils.ReadFileAsIntegers("day01/data_01")
	var increased = 0
	for index, cur := range data {
		if index != 0 {
			if cur > data[index-1] {
				increased += 1
			}
		}
	}
	fmt.Println(increased)
}

func Task02() {
	var data = utils.ReadFileAsIntegers("day01/data_01")
	var currentIndex = 0
	var increased = 0
	var v1, v2 = make([]int64, 0), make([]int64, 0)

	for currentIndex+3 < len(data) {
		v1 = data[currentIndex : currentIndex+3]
		v2 = data[currentIndex+1 : currentIndex+4]
		if sum(v1) < sum(v2) {
			increased++
		}
		currentIndex++
	}
	fmt.Println(increased)
}
func sum(array []int64) int64 {
	var result int64 = 0
	for _, v := range array {
		result += v
	}
	return result
}
