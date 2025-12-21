const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./baekjoon/input.txt")
    .toString()
    .trim()
    .split("\n")

const [n, m, v] = input[0].split(" ").map(Number)
let graph = Array.from({ length: n + 1 }, () => [])
for (let i = 1; i <= m; i++) {
    let [a, b] = input[i].split(" ").map(Number)
    graph[a].push(b)
    graph[b].push(a)
}

for (let i = 1; i <= n; i++) {
    graph[i].sort((a, b) => a - b)
}

let result = []
let visited = Array(n + 1).fill(false)

const dfs = (x) => {
    result.push(x)
    visited[x] = true

    for (let neighbor of graph[x]) {
        if (!visited[neighbor]) {
            dfs(neighbor)
        }
    }
}
dfs(v)
console.log(result.join(" "))

const bfs = (x) => {
    let queue = [x]
    let result = [x]
    let visited = Array(n + 1).fill(false)
    visited[x] = true

    while (queue.length) {
        let x = queue.shift()

        for (let neighbor of graph[x]) {
            if (!visited[neighbor]) {
                visited[neighbor] = true
                queue.push(neighbor)
                result.push(neighbor)
            }
        }
    }
    return result.join(" ")
}

console.log(bfs(v))