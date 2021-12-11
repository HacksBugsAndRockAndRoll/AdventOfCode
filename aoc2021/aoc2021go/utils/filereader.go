package utils

import (
	"bufio"
	"os"
	"strconv"
)

func ReadFileAsStrings(path string) []string {
	dat, _ := os.Open(path)
	scanner := bufio.NewScanner(dat)
	scanner.Split(bufio.ScanLines)
	data := make([]string, 0)
	for scanner.Scan() {
		data = append(data, scanner.Text())
	}
	return data
}

func ReadFileAsIntegers(path string) []int64 {
	dat, _ := os.Open(path)
	scanner := bufio.NewScanner(dat)
	scanner.Split(bufio.ScanLines)
	data := make([]int64, 0)
	for scanner.Scan() {
		var current, _ = strconv.ParseInt(scanner.Text(), 10, 64)
		data = append(data, current)
	}
	return data
}
