#include <stdio.h>
#include <cstring>

void spiralPrinting(int nRow, int nCol) {
    int spiralArray[nRow][nCol];
    memset(spiralArray, 0, nRow * nCol);
    
    //value to print
    int value = 1;
    int colIdx = 0, rowIdx = 0, lastColIdx = nCol - 1, lastRowIdx = nRow - 1;
    int i;
    while (value <= nRow * nCol) {
        //do the first row
        int num = nCol - colIdx;
        for (i = colIdx; i < num; i++) {
            spiralArray[rowIdx][i] = value++;
        }
        rowIdx++;
        
        //do the last column
        num = nRow - rowIdx;
        int did = 0;
        for (i = rowIdx; i <= lastRowIdx && colIdx <= lastColIdx; i++) {
            spiralArray[i][lastColIdx] = value++;
            did = 1;
        }
        lastColIdx -= did;
        
        //do the last row
        did = 0;
        for (i = lastColIdx; i >= colIdx && rowIdx <= lastRowIdx; i--) {
            spiralArray[lastRowIdx][i] = value++;
            did  =1;
        }
        lastRowIdx -= did;

        //do the first column
        for (i = lastRowIdx; i >= rowIdx && colIdx <= lastColIdx; i--) {
            spiralArray[i][colIdx] = value++;
        }
        colIdx++;
    }
    
    for (i = 0; i < nRow; i++) {
        for (int j = 0; j < nCol; j++) {
            printf("%2d ", spiralArray[i][j]);
        }
        printf("\n");
    }
}

int main(int argc, const char * argv[]) {
    spiralPrinting(4, 4);
    return 0;
}