import sys

Users=dict()
def executeTransaction(Key, Name, Amount):
    if Key=='A':
        if Name in Users:
            return 'False'
        else:
            Users[Name]=Amount
            return 'True'
    elif Key=='D':
        if Name not in Users:
            return 'False'
        else:
            Users[Name]=Users[Name]+Amount
            return 'True'
    elif Key=='W':
        if Name in Users and Amount<=Users[Name]:
            Users[Name]=Users[Name]-Amount
            return 'True'
        else:
            return 'False'
    else:
        return 'Invalid'

for line in sys.stdin:
    Key,Name,Amount=line.strip().split(' ')
    Amount=float(Amount)
    print executeTransaction(Key, Name, Amount)
