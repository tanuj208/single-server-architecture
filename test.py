import random

f1 = open("test1", 'w+')
f2 = open("test2", 'w+')

n = 2000
m = 10000

f1.write("add_graph graph " + str(n) + "\n")
f2.write(str(n) + " " + str(m) + "\n")
for i in range(m):
	a = random.randrange(1, n+1, 1)
	b = random.randrange(1, n+1, 1)
	w = random.randrange(1, 10000, 1)
	f1.write("add_edge graph " + str(a) + " " + str(b) + " " + str(w) + "\n")
	f2.write(str(a) + " " + str(b) + " " + str(w) + "\n")
f1.write("get_mst graph\n")