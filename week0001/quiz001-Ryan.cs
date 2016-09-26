using System;

namespace DVRK
{
    class Program
    {
        static void Main(string[] args)
        {
            for (int i = 1; i <= 100; i++)
            {
                if (i % 3 == 0)
                    Console.WriteLine("Fizz\n");
                if (i % 5 == 0)
                    Console.WriteLine("Buzz\n");
            }
        }
    }
}
