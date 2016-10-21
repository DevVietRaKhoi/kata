import sys


class Guests():

    def __init__(self):
        self.fileRecords = dict()
        self.printFormat = dict()


def readFile(guests, fileName):
    try:
        f = open(fileName)
        f.readline()
        content = f.readlines()
        for line in content:
            firstName, lastName, email = line.strip().split(',')
            if email in guests.fileRecords:
                if fileName in guests.fileRecords[email]:
                    raise Exception('IO Error', 'Duplicated users with the same email')
                guests.fileRecords[email].append(fileName)
            else:
                guests.fileRecords[email] = [fileName]
            guests.printFormat[email] = firstName + \
                ' ' + lastName + ' <' + email + '>'
    except IOError:
        raise Exception('IO Error', 'Reading file')

def findCommonGuests(guests, firstFile, secondFile):

    readFile(guests, firstFile)
    readFile(guests, secondFile)
    commonGuests = []
    for key in guests.fileRecords.keys():
        if len(guests.fileRecords[key]) == 2:
            commonGuests.append(guests.printFormat[key])
    commonGuests.sort()
    for guest in commonGuests:
        print guest


if __name__ == "__main__":
    guests = Guests()
    findCommonGuests(guests, sys.argv[1], sys.argv[2])
