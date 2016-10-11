import sys


class Users():

    def __init__(self):
        self.data = dict()

    def addAccount(self, Name, Amount):
        if Name in self.data:
            return 'False'
        else:
            self.data[Name] = Amount
            return 'True'

    def depositMoney(self, Name, Amount):
        if Name not in self.data:
            return 'False'
        else:
            self.data[Name] = self.data[Name] + Amount
            return 'True'

    def withdrawMoney(self, Name, Amount):
        if Name in self.data and Amount <= self.data[Name]:
            self.data[Name] = self.data[Name] - Amount
            return 'True'
        else:
            return 'False'

sampleData = Users()
for line in sys.stdin:
    Key, Name, Amount = line.strip().split(' ')
    Amount = float(Amount)
    if Key == 'A':
        print sampleData.addAccount(Name, Amount)
    elif Key == 'D':
        print sampleData.depositMoney(Name, Amount)
    elif Key == 'W':
        print sampleData.withdrawMoney(Name, Amount)
    else:
        print 'Invalid'
