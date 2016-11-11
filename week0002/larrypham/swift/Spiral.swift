/**
 * Given an integer N, generate a square matrix filled with elements from 1 to n*n in spiral order
 * with n= 4, we have:
 *	1  2  3  4
 *	12 13 14  5
 *	11 16 15  6
 *	10  9  8  7
 **/
import Foundation

class Solution {
    
    func generateMatrix(n: Int) -> [[Int]] {
        var res = Array<[Int]>(repeating: Array<Int>(repeating: 0, count: n), count: n)
        var k = 1, i = 0
        while k <= n * n {
            var j = i
            while j < n - i {
                res[i][j] = k
                j += 1
                k += 1
            }
            
            j = i + 1
            while j < n - i {
                res[j][n-i-1] = k
                j += 1
                k += 1
            }
            
            j = n - i - 2
            while j > i {
                res[n-i-1][j] = k
                j -= 1
                k += 1
            }
            
            j = n - i - 1
            while j > i {
                res[j][i] = k
                j -= 1
                k += 1
            }
            
            i += 1
        }
        return res
    }
}



