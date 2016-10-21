using System;
using System.Collections.Generic;
using System.IO;

namespace DVRK
{
    class Program
    {
        public static Dictionary<string, string> guestList;

        static void Main(string[] args)
        {
            guestList = new Dictionary<string, string>(StringComparer.OrdinalIgnoreCase);
            string[] event1 = File.ReadAllLines("event1.input");
            string[] event2 = File.ReadAllLines("event2.input");

            foreach (string guestLine in event1)
            {
                foreach (string guestLine2 in event2)
                {
                    if (guestLine == guestLine2)
                    {
                        string[] guestInfo = guestLine.Split(',');
                        if (guestInfo[0] != "fname")
                        {
                            guestList.Add(string.Concat(guestInfo[0], " ", guestInfo[1]), guestInfo[2]);
                        }
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
