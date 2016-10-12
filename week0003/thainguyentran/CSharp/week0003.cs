using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;
using System.Linq;

namespace DVRK
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<string, double> clients = new Dictionary<string, double>();
            string[] temp = Console.ReadLine().Split(' ');
            switch(Convert.ToChar(temp[0]))
            {
                case 'A':
                    if (temp[1].All(char.IsLetter) && Convert.ToDouble(temp[2]) > 0)
                        if (!clients.ContainsKey(temp[1]))
                        {
                            clients.Add(temp[1], Convert.ToDouble(temp[2]));
                            Console.WriteLine("True");
                        }
                        else Console.WriteLine("False");
                    else Console.WriteLine("Invaild");
                    break;
                case 'D':
                    if (temp[1].All(char.IsLetter) && Convert.ToDouble(temp[2]) > 0)
                        if (clients.ContainsKey(temp[1]))
                        {
                            clients[temp[1]] += Convert.ToDouble(temp[2]);
                            Console.WriteLine("True");
                        }
                        else Console.WriteLine("False");
                    else Console.WriteLine("Invaild");
                    break;
                case 'W':
                    if (temp[1].All(char.IsLetter) && Convert.ToDouble(temp[2]) > 0)
                        if (clients.ContainsKey(temp[1]))
                            if (clients[temp[1]] >= Convert.ToDouble(temp[2]))
                            {
                                clients[temp[1]] -= Convert.ToDouble(temp[2]);
                                Console.WriteLine("True");
                            }
                            else Console.WriteLine("False");
                        else Console.WriteLine("False");
                    else Console.WriteLine("False");
                    break;
                default:
                    Console.WriteLine("Invaild");
                    break;
            }
        }
    }
}
