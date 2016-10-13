using System;
using System.Collections.Generic;
using System.Linq;

namespace DVRK
{
    class Program
    {
        public static Dictionary<string, double> clients = new Dictionary<string, double>();
        static void Main(string[] args)
        {
            string input = Console.ReadLine();     
            Console.WriteLine(bankingProcess(input));
        }
        public static string bankingProcess (string input)
        {
            string[] array = input.Split(' ');

            char Trigger = Convert.ToChar(array[0]);
            string Name = array[1];
            double Amount = Convert.ToDouble(array[2]);
            switch (Trigger)
            {
                case 'A':
                    if (Name.All(char.IsLetter) && Amount > 0)
                        if (!clients.ContainsKey(Name))
                        {
                            clients.Add(Name, Amount);
                            return("True");
                        }
                        else return ("False");
                    else return ("Invaild");
                case 'D':
                    if (Name.All(char.IsLetter) && Amount > 0)
                        if (clients.ContainsKey(Name))
                        {
                            clients[Name] += Amount;
                            return ("True");
                        }
                        else return ("False");
                    else return ("Invaild");
                case 'W':
                    if (Name.All(char.IsLetter) && Amount > 0)
                        if (clients.ContainsKey(Name))
                            if (clients[Name] >= Amount)
                            {
                                clients[Name] -= Amount;
                                return ("True");
                            }
                            else return ("False");
                        else return ("False");
                    else return ("False");
                default:
                    return ("Invaild");
            }
        }
    }
}
