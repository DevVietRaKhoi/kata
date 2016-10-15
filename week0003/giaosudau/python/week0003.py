import sys

ACTION_ADD_CLIENT = 'A'
ACTION_CLIENT_DEPOSIT = 'D'
ACTION_CLIENT_WITHDRAW = 'W'


class Client():
    def __init__(self, name, amount):
        self.name = name
        self.amount = amount

    def deposit(self, amount):
        if amount > 0:
            self.amount += amount
            return True
        else:
            return False

    def withdraw(self, amount):
        if 0 < amount <= self.amount:
            self.amount -= amount
            return True
        else:
            return False


class Bank(object):
    def __init__(self):
        self.clients = {}

    def process(self, input):
        for line in input:
            data = line.split(" ")
            action = data[0]
            name = data[1].lower()
            amount = float(data[2])
            if amount > 0:
                if action == ACTION_ADD_CLIENT:
                    print self.add_client(name, amount)
                elif action == ACTION_CLIENT_DEPOSIT:
                    print self.deposit(name, amount)
                elif action == ACTION_CLIENT_WITHDRAW:
                    print self.withdraw(name, amount)
                else:
                    print 'Invalid'
            else:
                print 'Invalid'

    def add_client(self, name, amount):
        if name in self.clients:
            return False
        else:
            client = Client(name, amount)
            self.clients[name] = client
            return True

    def deposit(self, name, amount):
        if name in self.clients:
            client = self.clients[name]
            return client.deposit(amount)
        else:
            return False

    def withdraw(self, name, amount):
        if name in self.clients:
            client = self.clients[name]
            return client.withdraw(amount)
        else:
            return False


if __name__ == '__main__':
    bank = Bank()
    bank.process(sys.stdin)
