import sys


class Accounts():

    def __init__(self):
        self.data = dict()

    def addAccount(self, name, amount):
        if name not in self.data and amount >= 0:
            self.data[name] = amount
            return 'True'
        else:
            return 'False'

    def depositMoney(self, name, amount):
        if name in self.data and amount >= 0:
            self.data[name] = self.data[name] + amount
            return 'True'
        else:
            return 'False'

    def withdrawMoney(self, name, amount):
        if name in self.data and amount >= 0 and amount <= self.data[name]:
            self.data[name] = self.data[name] - amount
            return 'True'
        else:
            return 'False'

    def executeTransaction(self, inputTransaction):
        key, name, amount = inputTransaction.strip().split(' ')
        amount = float(amount)
        if key == 'A':
            return self.addAccount(name, amount)
        elif key == 'D':
            return self.depositMoney(name, amount)
        elif key == 'W':
            return self.withdrawMoney(name, amount)
        else:
            return 'Invalid'


if __name__ == "__main__":
    sampleAccounts = Accounts()
    for line in sys.stdin:
        print sampleAccounts.executeTransaction(line)
