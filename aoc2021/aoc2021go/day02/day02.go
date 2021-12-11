package day02

import (
	"aoc2021go/utils"
	"fmt"
	"strconv"
	"strings"
)

func Task01() {
	var data = utils.ReadFileAsStrings("day02/data_01")
	var h, v int64 = 0, 0
	for _, cur := range data {
		pair := strings.Split(cur, " ")
		var value, _ = strconv.ParseInt(pair[1], 10, 64)
		switch pair[0] {
		case "up":
			h -= value
		case "down":
			h += value
		case "forward":
			v += value
		}
	}
	fmt.Println(h * v)
}

func Task02() {
	var data = utils.ReadFileAsStrings("day02/data_01")
	var h, d, a int64 = 0, 0, 0
	for _, cur := range data {
		pair := strings.Split(cur, " ")
		var value, _ = strconv.ParseInt(pair[1], 10, 64)
		switch pair[0] {
		case "up":
			a -= value
		case "down":
			a += value
		case "forward":
			h += value
			d += a * value
		}
	}
	fmt.Println(h * d)
}
