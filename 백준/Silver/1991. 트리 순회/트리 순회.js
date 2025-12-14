const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./baekjoon/input.txt")
    .toString()
    .trim()
    .split("\n")

const n = Number(input[0])
let graph = {}
for (let i = 1; i <= n; i++) {
    const [root, left, right] = input[i].trim().split(" ")
    if (!graph[root]) graph[root] = []
    graph[root].push(left, right)
}

const preorder = () => {
    let result = []

    const dfs = (node) => {
        if (node === ".") return
        result.push(node)

        for (let next of graph[node]) {
            dfs(next)
        }
    }
    dfs("A")
    console.log(result.join(""))
}

const inorder = () => {
    let result = []

    const dfs = (node) => {
        if (node === ".") return

        let [left, right] = graph[node]
        dfs(left)
        result.push(node)
        dfs(right)

    }
    dfs("A")
    console.log(result.join(""))
}

const postorder = () => {
    let result = []

    const dfs = (node) => {
        if (node === ".") return

        for (let next of graph[node]) {
            dfs(next)
        }
        result.push(node)
    }
    dfs("A")
    console.log(result.join(""))
}

preorder()
inorder()
postorder()