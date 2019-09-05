from urllib import request


url = 'http://www.google.com'
site = request.urlopen(url)
page = site.read()
# print(page)
print(site.status)
headers = site.getheaders()
print(headers)

for k, v in headers:
    print(k, v)
