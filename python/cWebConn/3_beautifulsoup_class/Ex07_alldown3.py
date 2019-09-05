"""
    파이썬은 파일하나를 모듈로 취급한다면 다른 파일의 함수를 복사하지 않고 바로 호출한다.

    [주의] import Ex07_alldown1 코드부터 에러발생하지만 실행은 됨

"""

from bs4 import BeautifulSoup
from urllib.parse import *
from urllib.request import *
import os, time, re

# 에러 발생해도 실행은됨
import Ex07_alldown1
import Ex07_alldown2

# 이미 처리한 파일인지 확인하기 위한 변수
proc_files = {}


# HTML을 다운 > 분석하는 함수
def analyze_html(url, root_url):
    # ------------------------------------------------------
    save_path = Ex07_alldown2.download_file(url)
    if save_path is None:
        return
    if save_path in proc_files:
        return
    proc_files[save_path] = True
    # print(proc_files)   # {'./docs.python.org/3.5/library/index.html': True}
    f = open(save_path, "r", encoding='utf-8')
    html = f.read()
    links = Ex07_alldown1.enum_links(html, url)
    # print(links)    # ['https://docs.python.org/3.5/genindex.html', 'https://docs.python.org/3.5/py-modindex.html', 'https://docs.python.org/3.5/library/intro.html', 계속...]
    for url_link in links:
        if url_link.find(root_url) != 0:
            continue
        if re.search(".html$", url_link):
            analyze_html(url_link, root_url)
            continue
        Ex07_alldown2.download_file(url_link)

if __name__ == "__main__":
    # URL에 있는 모든 것 다운받기
    url = "https://docs.python.org/3.5/library/"
    analyze_html(url, url)
