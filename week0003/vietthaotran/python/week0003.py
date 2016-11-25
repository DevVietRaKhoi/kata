import sys

class Client (object):
	def __init__(self, name, amount):
		self.name = name
		self.amount = amount

	def deposit(self, amount):
		if amount > 0:
			self.amount += amount
			return 'True'
		else:
			return 'False'

	def withdraw(self, amount):
		if 0 < amount <= self.amount:
			self.amount -= amount
			return 'True'
		else:
			return 'False'

class FinTech (object):
	def __init__(self):
		self.clients = {}

	def addClient (self, name, amount):
		if name in self.clients:
			return 'False'
		else:
			client = Client(name, amount)
			self.clients[name] = client
			return 'True'

	def deposit(self, name, amount):
		if name in self.clients:
			client = self.clients[name]
			return client.deposit(amount)
		else:
			return 'False'

	def withdraw(self, name, amount):
		if name in self.clients:
			client = self.clients[name]
			return client.withdraw(amount)
		else:
			return 'False'

	def processRequest(self, input):
		for line in input:
			request = line.split(" ")
			action = request[0]
			name = request[1].lower()
			amount = float(request[2])
			if amount > 0:
				if action == 'A':
					print self.addClient(name, amount)
				elif action == 'D':
					print self.deposit(name, amount)
				elif action == 'W':
					print self.withdraw(name, amount)
				else:
					print 'Invalid'
			else:
				print 'Invalid'
 

if __name__ == '__main__':
	finTech = FinTech()
	finTech.processRequest(sys.stdin)
