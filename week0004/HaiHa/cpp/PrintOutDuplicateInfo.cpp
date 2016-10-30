#include <algorithm>
#include <fstream>
#include <iostream>
#include <set>
#include <regex>

class Participant
{

public:
  Participant (std::string firstName, std::string lastName, std::string email) :
    m_firstName(firstName),
    m_lastName(lastName),
    m_email(email)
    {
    }

  bool operator< (const Participant &rhs) const
  {
    if (m_firstName != rhs.m_firstName)
      return (m_firstName < rhs.m_firstName);
    else if (m_lastName != rhs.m_lastName)
      return (m_lastName < rhs.m_lastName);
    else
      return (m_email < rhs.m_email);
  }

  friend std::ostream & operator<<(std::ostream &out, Participant input)
  {
    return out << input.m_firstName << " " << input.m_lastName << " <" <<
      input.m_email << ">";
  }

private:
  std::string m_firstName;
  std::string m_lastName;
  std::string m_email;
};

typedef std::set<Participant> SortedParticipantList;

//------------------------------------------------------------------------------

/**Parse a line and add it to the participant list**/
void ParseParticipantInformation(const std::string &line, SortedParticipantList
    &ParticipantList, const std::regex &pattern)
{
  std::smatch match;

  if ((std::regex_match(line, match,pattern)) && (match.size() == 4))
    ParticipantList.emplace(match[1], match[2], match[3]);
}

//------------------------------------------------------------------------------

/** Get participant list from input file**/
void GetParticipantListFromFile(const std::string &fileName, SortedParticipantList &ParticipantList)
{
  std::ifstream inputStream(fileName);
  std::string line;

  if(!inputStream)
  {
    std::cout << "Cannot open input file.\n";
  }
  else
  {
    //Ignore the first line as title.
    std::getline(inputStream, line);

    const std::regex pattern("(\\w+),(\\w++),([A-z0-9._%+-]+@\\w+\\.\\w+)");

    while (std::getline(inputStream, line))
      ParseParticipantInformation(line, ParticipantList, pattern);

    inputStream.close();
  }
}

//------------------------------------------------------------------------------

void PrintOutIntersectionForSets(const SortedParticipantList &list1, const SortedParticipantList &list2)
{
  std::set_intersection(list1.begin(), list1.end(), list2.begin(), list2.end(),
    std::ostream_iterator<Participant>(std::cout, "\n"));
}


int main(int argc, char *argv[])
{
  SortedParticipantList eventA;
  SortedParticipantList eventB;

  // Get file names from command line
  GetParticipantListFromFile(argv[1], eventA);
  GetParticipantListFromFile(argv[2], eventB);

  PrintOutIntersectionForSets(eventA, eventB);

  return 0;
}
