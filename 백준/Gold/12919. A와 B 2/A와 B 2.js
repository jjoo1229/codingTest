const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./baekjoon/input.txt")
    .toString()
    .trim()
    .split("\n")

const s = input[0].trim()
let t = input[1].trim()

const dfs = (cur) => {
    if (cur.length < s.length) return false
    if (cur === s) return true

    if (cur.startsWith("B")) {
        let ncur = cur.slice(1).split("").reverse().join("")
        if (dfs(ncur)) return true
    }
    if (cur.endsWith("A")) {
        let ncur = cur.slice(0, cur.length - 1)
        if (dfs(ncur)) return true
    }
    return false
}
console.log(dfs(t) ? 1 : 0)