import sys

ACTION_ADD_ACCOUNT = 'A'
ACTION_DEPOSIT_MONEY = 'D'
ACTION_WITHDRAW_MONEY = 'W'


class Accounts():

    def __init__(self):
        self.data = dict()

    def addAccount(self, name, amount):
        if name not in self.data and amount > 0:
            self.data[name] = amount
            return 'True'
        else:
            return 'False'

    def depositMoney(self, name, amount):
        if name in self.data and amount > 0:
            self.data[name] += amount
            return 'True'
        else:
            return 'False'

    def withdrawMoney(self, name, amount):
        if name in self.data and amount > 0 and amount <= self.data[name]:
            self.data[name] -= amount
            return 'True'
        else:
            return 'False'


def executeTransaction(accounts, inputTransaction):
    key, name, amount = inputTransaction.strip().split(' ')
    amount = float(amount)
    name = name.lower()
    if key == ACTION_ADD_ACCOUNT:
        return accounts.addAccount(name, amount)
    elif key == ACTION_DEPOSIT_MONEY:
        return accounts.depositMoney(name, amount)
    elif key == ACTION_WITHDRAW_MONEY:
        return accounts.withdrawMoney(name, amount)
    else:
        return 'Invalid'

if __name__ == "__main__":
    sampleAccounts = Accounts()
    for line in sys.stdin:
        print executeTransaction(sampleAccounts, line)
