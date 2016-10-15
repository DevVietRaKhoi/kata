import sys


class Client():
    def __init__(self):
        pass

    def __init__(self, name, amount):
        self.name = name
        self.amount = amount

    def deposit(self, amount):
        self.amount += amount
        return True

    def with_draw(self, amount):
        if amount <= self.amount:
            self.amount -= amount
            return True
        else:
            return False


class Bank(object):
    clients = {}

    def add_client(self, name, amount):
        if name in self.clients:
            return False
        else:
            client = Client(name, amount)
            self.clients[name] = client
            return True

    def process(self, input):
        for line in input:
            data = line.split(" ")
            action = data[0]
            name = data[1]
            amount = int(data[2])
            if action == 'A':
                print self.add_client(name, amount)
            elif action == 'D':
                print self.deposit(name, amount)
            elif action == 'W':
                print self.with_draw(name, amount)
            else:
                print 'Invalid'

    def deposit(self, name, amount):
        if name in self.clients:
            client = self.clients[name]
            return client.deposit(amount)
        else:
            return False

    def with_draw(self, name, amount):
        if name in self.clients:
            client = self.clients[name]
            return client.with_draw(amount)
        else:
            return False


if __name__ == '__main__':
    bank = Bank()
    bank.process(sys.stdin)
