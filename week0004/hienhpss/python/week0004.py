import csv
from csv import Dialect
import sys
from hashlib import md5

def read_csv(filename):
	'''Reader csv files with header. General function that can be reused'''
	with open(filename, newline='') as csv_file:
		# Read the header from first line
		header = csv_file.readline().rstrip().split(',')
		# Read the csv using the header obtained above
		csv_reader = csv.DictReader(csv_file, delimiter = ',', fieldnames = header)
		for row in csv_reader:
			yield(row)

def generate_md5(*args):
	'''Generate md5 from list of strings. General function that can be reused'''
	m = md5()
	for i in args:
		# Encode first
		i_enc = i.encode('utf-8')
		m.update(i_enc)
	return m.digest()

def week4_csv_to_dict(csv_rows):
	'''Convert an iterator of rows into dictionary
	with key as hash of the whole row. This function is not generic 
	and can be used for week0004 practice only'''
	result = dict()
	for row in csv_rows:
		md5_email = generate_md5(row['email'])
		#only add into dict if email is not used. Skip those duplicate emails
		if not md5_email in list(result.keys()):
			result[md5_email] = row
	return result


def week4_match_sources():
	'''Match the 2 input file and return the people
	who subscribe to both'''
	file1 = sys.argv[1]
	file2 = sys.argv[2]
	source1 = week4_csv_to_dict(read_csv(file1))
	source2 = week4_csv_to_dict(read_csv(file2))
	for key in set(source1.keys()):
		if key in set(source2.keys()):
			if source1[key]['fname'] == source2[key]['fname'] and source1[key]['lname'] == source2[key]['lname']:
				yield(source1[key])

def week4_output(output_file='guests.output'):
	'''Outout list of duplicate guests to file'''
	f = open(output_file,'w')
	for person in week4_match_sources():
		print('{:s} {:s} <{:s}>'.format(str(person['fname']),str(person['lname']),str(person['email'])))
	f.close()

if __name__ == "__main__":
	week4_output('guest.output')