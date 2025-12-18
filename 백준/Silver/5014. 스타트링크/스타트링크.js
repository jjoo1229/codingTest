const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./baekjoon/input.txt")
    .toString()
    .trim()
    .split("\n")

const [f, s, g, u, d] = input[0].split(" ").map(Number)

const move = [u, -d]

const bfs = (s, g) => {
    let queue = [[s, 0]]
    let visited = Array(f + 1).fill(false)
    visited[s] = true

    while (queue.length) {
        let [x, count] = queue.shift()

        if (x === g) return count

        for (let m of move) {
            let floor = x + m
            if (floor <= 0 || floor > f) continue
            if (!visited[floor]) {
                visited[floor] = true
                queue.push([floor, count + 1])
            }
        }
    }
    return "use the stairs"
}
console.log(bfs(s, g))