package main

import (
	"aoc2021go/day01"
	"aoc2021go/day02"
	"aoc2021go/day03"
	"os"
)

func main() {

	switch os.Args[1] {
	case "0101":
		day01.Task01()
	case "0102":
		day01.Task02()
	case "0201":
		day02.Task01()
	case "0202":
		day02.Task02()
	case "0301":
		day03.Task01()
	case "0302":
		day03.Task02()
	}
}
