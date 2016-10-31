using System;
using System.Collections.Generic;
using System.IO;

namespace DVRK
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] event1 = File.ReadAllLines(args[0]);
            string[] event2 = File.ReadAllLines(args[1]);

            EventHandling eventHandling = new EventHandling();
            eventHandling.showDoubleRegisterGuest(event1, event2);
        }
    }
    class EventHandling
    {
        Dictionary<string, string> guestList = new Dictionary<string, string>(StringComparer.OrdinalIgnoreCase);

        public void showDoubleRegisterGuest(string[] guestOfEvent1, string[] guestOfEvent2)
        {
            string fName, lName, email;

            for(int i = 1; i < guestOfEvent1.Length; i++)
            {
                for(int j = 1; j < guestOfEvent2.Length; j++)
                { 
                    if (guestOfEvent1[i] == guestOfEvent2[j])
                    {
                        string[] guestInfo = guestOfEvent1[i].Split(',');
                        fName = guestInfo[0];
                        lName = guestInfo[1];
                        email = guestInfo[2];
                        guestList.Add(string.Concat(fName, " ", lName), email);
                    }
                }
            }

            foreach (KeyValuePair<string, string> info in guestList)
            {
                Console.WriteLine("{0} <{1}>", info.Key, info.Value);
            }
        }
    }
}
