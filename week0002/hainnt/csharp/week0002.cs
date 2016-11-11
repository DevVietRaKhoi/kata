using System;
using System.Collections.Generic;
using System.Linq;

namespace Week0002
{
    public static class Week0002
    {
        public static void Main(string[] args)
        {
            while (true)
            {
                Console.Write("Input M: ");
                var m = Convert.ToInt32(Console.ReadLine());
                Console.Write("Input N: ");
                var n = Convert.ToInt32(Console.ReadLine());

                var arr = Cal(m, n);

                foreach (var i in arr)
                {
                    foreach (var j in i)
                    {
                        Console.Write(Draw(j, m * n) + "    ");
                    }
                    Console.WriteLine();
                }
                Console.WriteLine();
            }
        }

        public static List<List<int>> Cal(double m, double n)
        {
            var array = new List<List<int>>();

            //Allocate 2 dimension array
            for (var i = 0; i < m; i++)
            {
                array.Add(new List<int>());
                for (var j = 0; j < n; j++)
                {
                    array[i].Add(0);
                }
            }

            var pointer = new Cell(0, 0);

            //Change direction points
            var MinMin = new Cell(1, 0);
            var MinMax = new Cell(0, n - 1);
            var MaxMax = new Cell(m - 1, n - 1);
            var MaxMin = new Cell(m - 1, 0);

            var move = new Cell(0, 1);

            for (var i = 1; i <= m * n; i++)
            {
                array[(int)pointer.X][(int)pointer.Y] = i;

                if (pointer.Equal(MinMin))
                {
                    move = new Cell(0, 1);

                    if (MinMin.X + 1 <= (m - 1) / 2 && MinMin.Y + 1 < (n - 1) / 2)
                    {

                        MinMin.X++; MinMin.Y++;
                    }
                }
                else if (pointer.Equal(MinMax))
                {
                    move = new Cell(1, 0);
                    if (MinMax.X + 1 <= (m - 1) / 2 && MinMax.Y - 1 >= (n - 1) / 2)
                    {
                        MinMax.X++; MinMax.Y--;
                    }
                }
                else if (pointer.Equal(MaxMax))
                {
                    if (MaxMax.X - 1 >= (m - 1) / 2 && MaxMax.Y - 1 >= (n - 1) / 2)
                    {
                        MaxMax.X--; MaxMax.Y--;
                    }
                    move = new Cell(0, -1);
                }
                else if (pointer.Equal(MaxMin))
                {
                    if (MaxMin.X - 1 > (m - 1) / 2 && MaxMin.Y + 1 <= (n - 1) / 2)
                    {
                        MaxMin.X--; MaxMin.Y++;
                    }
                    move = new Cell(-1, 0);
                }
                

                pointer += move;
            }

            return array;
        }
        public static bool Equal(this Cell cell, Cell obj)
        {
            return cell.X == obj.X && cell.Y == obj.Y;
        }

        public static string Draw(int num, int max)
        {
            var result = "";
            var size = max.ToString().Count() - num.ToString().Count();
            for (var i = 0; i < size; i++)
            {
                result += " ";
            }
            return result += num;
        }
    }

    public class Cell
    {
        public Cell(double x, double y)
        {
            X = x;
            Y = y;
        }

        public double X { get; set; }
        public double Y { get; set; }

        public static Cell operator +(Cell c1, Cell c2)
        {
            return new Cell(c1.X + c2.X, c1.Y + c2.Y);
        }
    }
}
