using System;

namespace DVRK
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Enter the number of row N: ");
            int N = Convert.ToInt32(Console.ReadLine());
            Console.Write("Enter the number of column M: ");
            int M = Convert.ToInt32(Console.ReadLine());

            int[,] spiral = new int[N, M];
            int value = 1;
            int posX = N - 1, posY = M - 1;
            int row = 0, column = 0;

            while (value < N * M)
            {
                //going right
                for (int i = row; i <= posY; i++)
                {
                    spiral[row, i] = value++;
                }
                //going down
                for (int j = column + 1; j <= posX; j++)
                {
                    spiral[j, posY] = value++;
                }
                //going left
                for (int i = posY - 1; i >= column; i--)
                {
                    spiral[posX, i] = value++;
                }
                //going up
                for (int j = posX - 1; j >= row + 1; j--)
                {
                    spiral[j, column] = value++;
                }
                row++;
                column++;
                posX--;
                posY--;
            }
            int maxLen = (N * M).ToString().Length;
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < M; j++)
                {
                    Console.Write("{0}", spiral[i, j].ToString().PadLeft(maxLen + 1,' '));
                }
                Console.Write("\n");
            }
        }
    }
}
