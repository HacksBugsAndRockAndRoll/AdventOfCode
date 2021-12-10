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
	var current, prev, increased int64 = -1, -1, 0
	for scanner.Scan() {
		current, _ = strconv.ParseInt(scanner.Text(), 10, 64)
		if prev != -1 {
			if current > prev {
				increased += 1
			}
		}
		prev = current
	}
	fmt.Println(increased)
}
