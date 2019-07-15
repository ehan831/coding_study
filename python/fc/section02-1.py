# print
print('Hello Python!')
print("Hello Python!")
print("""Hello Python!""")
print('''Hello Python!''')

# Separator
print('T', 'E', 'S', 'T')
print('T', 'E', 'S', 'T', sep='')
print('emailAddress', 'google.com', sep='@')

# end
print('Welcome To', end=' ')
print('메뚜기 월드', end=' ')
print('헬로우')

# format
print('{} and {}'.format('YOU', 'ME'))
print('{0} and {1} and {0}'.format('YOU', "ME"))
print("{a} and {b}".format(a='YOU', b='ME'))
print("%s String %d Number" % ('A', 1))     # %s(String), %d (decimal), %f (float)
