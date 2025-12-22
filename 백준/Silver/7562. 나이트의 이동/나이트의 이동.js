const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./baekjoon/input.txt")
    .toString()
    .trim()
    .split("\n")

const n = Number(input[0])

const dir = [[-1, -2], [-1, 2], [1, 2], [1, -2], [-2, -1], [-2, 1], [2, 1], [2, -1]]

const bfs = (c, x1, y1, x2, y2) => {
    let visited = Array.from({ length: c }, () => Array(c).fill(false))
    visited[x1][y1] = true
    let queue = [[x1, y1, 0]]

    while (queue.length) {
        let [x, y, count] = queue.shift()
        if (x == x2 && y == y2) return count

        for (i = 0; i < 8; i++) {
            let nx = x + dir[i][0]
            let ny = y + dir[i][1]

            if (nx < 0 || nx >= c || ny < 0 || ny >= c) continue
            if (!visited[nx][ny]) {
                visited[nx][ny] = true
                queue.push([nx, ny, count + 1])
            }
        }
    }
}

for (let i = 1; i <= n * 3; i = i + 3) {
    const c = Number(input[i])
    const [startX, startY] = input[i + 1].split(" ").map(Number)
    const [finalX, finalY] = input[i + 2].split(" ").map(Number)
    console.log(bfs(c, startX, startY, finalX, finalY))
}