import sys


class Guest():

    def __init__(self, firstName, lastName, email):
        self.firstName = firstName
        self.lastName = lastName
        self.email = email
        self.eventFiles = dict()

    def __str__(self):
        return '{firstName} {lastName} <{email}>'.format(
            firstName=self.firstName, lastName=self.lastName, email=self.email)

    def getKey(self):
        return self.email


class EventManagement():

    def __init__(self):
        self.guests = dict()

    def isValidGuest(self, newGuest):
        newGuestKey = newGuest.getKey()
        if newGuestKey in self.guests:
            if newGuest.firstName != self.guests[newGuestKey].firstName \
                    or newGuest.lastName != self.guests[newGuestKey].lastName:
                raise Exception(
                    'IO Error', 'Duplicated users with the same email')
                return False
        return True

    def addGuest(self, newGuest):
        newGuestKey = newGuest.getKey()
        if newGuestKey in self.guests:
            self.guests[newGuestKey].eventFiles.update(
                newGuest.eventFiles)
        else:
            self.guests[newGuestKey] = newGuest

    def readFile(self, fileName):
        try:
            f = open(fileName)
            f.readline()
            content = f.readlines()
            for line in content:
                firstName, lastName, email = line.strip().split(',')
                newGuest = Guest(firstName, lastName, email)
                newGuest.eventFiles[fileName] = True
                if self.isValidGuest(newGuest):
                    self.addGuest(newGuest)
        except IOError:
            raise Exception('IO Error', 'Error reading file')

    def findCommonGuests(self, firstFile, secondFile):

        self.readFile(firstFile)
        self.readFile(secondFile)
        commonGuests = []
        for key in self.guests.keys():
            if firstFile in self.guests[key].eventFiles and secondFile in self.guests[key].eventFiles:
                commonGuests.append(self.guests[key])
        return sorted(commonGuests)

if __name__ == "__main__":
    eventManager = EventManagement()
    commonGuests = eventManager.findCommonGuests(sys.argv[1], sys.argv[2])
    for guest in commonGuests:
        print guest
