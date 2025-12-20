package main

import (
	"bufio"
	"fmt"
	"os"
)

type Point struct {
	r, c int
	dist int
}

var (
	N, M        int
	grid        [][]int
	maxDist     int = -1
	maxPassword int = 0

	dr = []int{1, -1, 0, 0}
	dc = []int{0, 0, -1, 1}
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	fmt.Fscan(reader, &N, &M)
	grid = make([][]int, N)
	for i := 0; i < N; i++ {
		grid[i] = make([]int, M)
		for j := 0; j < M; j++ {
			fmt.Fscan(reader, &grid[i][j])
		}
	}

	for i := 0; i < N; i++ {
		for j := 0; j < M; j++ {
			if grid[i][j] != 0 {
				BFS(i, j)
			}
		}
	}

	fmt.Fprintln(writer, maxPassword)

}

func BFS(startR, startC int) {
	queue := []Point{{r: startR, c: startC, dist: 0}}

	visited := make([][]bool, N)
	for i := range visited {
		visited[i] = make([]bool, M)
	}
	visited[startR][startC] = true

	for len(queue) > 0 {
		curr := queue[0]
		queue = queue[1:]

		currentSum := grid[startR][startC] + grid[curr.r][curr.c]

		if curr.dist > maxDist {
			maxDist = curr.dist
			maxPassword = currentSum
		} else if curr.dist == maxDist {
			if currentSum > maxPassword {
				maxPassword = currentSum
			}
		}

		// 7. 4방향 탐색
		for i := 0; i < 4; i++ {
			nr, nc := curr.r+dr[i], curr.c+dc[i]

			if nr >= 0 && nr < N && nc >= 0 && nc < M {
				if grid[nr][nc] != 0 && !visited[nr][nc] {
					visited[nr][nc] = true
					queue = append(queue, Point{r: nr, c: nc, dist: curr.dist + 1})
				}
			}
		}
	}
}
