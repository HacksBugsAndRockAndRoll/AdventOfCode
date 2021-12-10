package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func main() {

	dat, _ := os.Open("configs/data_01-01")
	scanner := bufio.NewScanner(dat)
	scanner.Split(bufio.ScanLines)
	data := make([]int64, 0)
	for scanner.Scan() {
		var current, _ = strconv.ParseInt(scanner.Text(), 10, 64)
		data = append(data, current)
	}
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
