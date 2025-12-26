package main

import (
	"bufio"
	"fmt"
	"os"
)

var (
	n       int
	m       int
	grid    [][]int
	visited [][]bool
	max     int

	dx = []int{1, -1, 0, 0}
	dy = []int{0, 0, -1, 1}
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	fmt.Fscan(reader, &n, &m)

	grid = make([][]int, n)
	visited = make([][]bool, n)
	for i := 0; i < n; i++ {
		grid[i] = make([]int, m)
		visited[i] = make([]bool, m)
		for j := 0; j < m; j++ {
			fmt.Fscan(reader, &grid[i][j])
		}
	}

	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			visited[i][j] = true
			dfs(i, j, grid[i][j], 1)
			visited[i][j] = false

			checkTShape(i, j)
		}
	}

	fmt.Fprintln(writer, max)
}

func dfs(x, y, sum, depth int) {
	if depth == 4 {
		if sum > max {
			max = sum
		}
		return
	}

	for i := range 4 {
		nx, ny := x+dx[i], y+dy[i]

		if nx >= 0 && nx < n && ny >= 0 && ny < m {
			if !visited[nx][ny] {
				visited[nx][ny] = true
				dfs(nx, ny, sum+grid[nx][ny], depth+1)
				visited[nx][ny] = false
			}
		}
	}

}

func checkTShape(x, y int) {
	sum := grid[x][y]
	minVal := 1001
	cnt := 0

	for i := range 4 {
		nx, ny := x+dx[i], y+dy[i]

		if nx >= 0 && nx < n && ny >= 0 && ny < m {
			cnt++
			sum += grid[nx][ny]
			if grid[nx][ny] < minVal {
				minVal = grid[nx][ny]
			}
		}
	}

	if cnt < 3 {
		return
	}

	if cnt == 4 {
		sum -= minVal
	}

	if sum > max {
		max = sum
	}
}
