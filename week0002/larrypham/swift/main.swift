import Foundation

let size = Int(readLine()!)!
let solution = Solution()

let result: [[Int]] = solution.generateMatrix(n: size)
for var x in 0..<result.count {
    var line = ""
    for var y in 0..<result[x].count {
        line += String(result[x][y])
        line += " "
    }
    print(line)
}
