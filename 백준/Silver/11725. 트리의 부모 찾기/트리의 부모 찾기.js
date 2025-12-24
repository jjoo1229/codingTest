const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./baekjoon/input.txt")
    .toString()
    .trim()
    .split("\n")

const n = Number(input[0])
let graph = Array.from({ length: n + 1 }, () => [])
for (let i = 1; i < n; i++) {
    const [a, b] = input[i].split(" ").map(Number)
    graph[a].push(b)
    graph[b].push(a)
}

let result = {}
const bfs = (x) => {
    let queue = [x]
    let visited = Array(n + 1).fill(false)
    visited[x] = true

    while (queue.length){
        let x = queue.shift()
        for (let child of graph[x]){
            if (!visited[child]){
                result[child] = x
                queue.push(child)
                visited[child] = true
            }
        }
    }
    console.log(Object.values(result).join("\n"))
}
bfs(1)