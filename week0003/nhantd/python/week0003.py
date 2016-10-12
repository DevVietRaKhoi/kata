import sys


class Accounts():

    def __init__(self):
        self.data = dict()

    def addAccount(self, Name, Amount):
        if Name not in self.data and Amount >= 0:
            self.data[Name] = Amount
            return 'True'
        else:
            return 'False'

    def depositMoney(self, Name, Amount):
        if Name in self.data and Amount >= 0:
            self.data[Name] = self.data[Name] + Amount
            return 'True'
        else:
            return 'False'

    def withdrawMoney(self, Name, Amount):
        if Name in self.data and Amount >= 0 and Amount <= self.data[Name]:
            self.data[Name] = self.data[Name] - Amount
            return 'True'
        else:
            return 'False'

if __name__ == "__main__":
    sampleAccounts = Accounts()
    for line in sys.stdin:
        Key, Name, Amount = line.strip().split(' ')
        Amount = float(Amount)
        if Key == 'A':
            print sampleAccounts.addAccount(Name, Amount)
        elif Key == 'D':
            print sampleAccounts.depositMoney(Name, Amount)
        elif Key == 'W':
            print sampleAccounts.withdrawMoney(Name, Amount)
        else:
            print 'Invalid'
