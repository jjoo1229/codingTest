const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./baekjoon/input.txt")
    .toString()
    .trim()
    .split("\n")

const [a, b] = input[0].split(" ").map(Number)

const bfs = (x) => {
    let queue = [[x, 0]]

    while (queue.length) {
        let [x, answer] = queue.shift()

        if (x === a) return answer + 1
        if (x < a) return -1

        if (x % 2 === 0) {
            let nx = x / 2
            queue.push([nx, answer + 1])
        }
        if (String(x).endsWith("1")) {
            let nx = Number(String(x).split("").slice(0, - 1).join(""))
            queue.push([nx, answer + 1])
        }
    }
    return -1
}
console.log(bfs(b))