using System;
using System.Collections.Generic;
using System.Linq;

namespace DVRK
{
    class Program
    {
        public static Dictionary<string, double> clients;
        const char ACTION_ADDCLIENT = 'A';
        const char ACTION_DEPOSIT = 'D';
        const char ACTION_WITHDRAW = 'W';

        static void Main(string[] args)
        {
            clients = new Dictionary<string, double>(StringComparer.OrdinalIgnoreCase);
            string input = "";
            do {
                input = Console.ReadLine();
                if (input != "")
                    Console.WriteLine(bankingProcess(input));
            } while (input != "") ;
        }

        public static string bankingProcess (string input)
        {
            string[] keyword = input.Split(' ');
            char Trigger = Convert.ToChar(keyword[0]);
            string Name = keyword[1];
            double Amount = Convert.ToDouble(keyword[2]);
            

            switch (Trigger)
            {
                case ACTION_ADDCLIENT:
                    if (Name.All(char.IsLetter) && Amount > 0)
                        if (!clients.ContainsKey(Name))
                        {
                            clients.Add(Name, Amount);
                            return("True");
                        }
                        else return ("False");
                    else return ("Invaild");
                case ACTION_DEPOSIT:
                    if (Name.All(char.IsLetter) && Amount > 0)
                        if (clients.ContainsKey(Name))
                        {
                            clients[Name] += Amount;
                            return ("True");
                        }
                        else return ("False");
                    else return ("Invaild");
                case ACTION_WITHDRAW:
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
