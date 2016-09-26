using System;

namespace DVRK
{
    class Program
    {
        static void Main(string[] args)
        {
            for (int i = 1; i <= 100; i++)
            {
                if (i % 15 == 0)
                    Console.WriteLine("Fizz\nBuzz");
                else
                {
                    if (i % 3 == 0)
                        Console.WriteLine("Fizz");
                    if (i % 5 == 0)
                        Console.WriteLine("Buzz");
                }
            }
        }
    }
}
