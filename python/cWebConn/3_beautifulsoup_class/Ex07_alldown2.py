"""
    파일을 다운받고 저장하는 함수

     [참고] 파이썬 정규식 표현 : https://wikidocs.net/4308
"""
import os
import re   # re : 정규식
import time
from urllib import parse
from urllib import request


def download_file(url):
    p = parse.urlparse(url)
    print('1-', p)
    save_path = './' + p.netloc + p.path
    print('2-', save_path)
    if re.search('/$', save_path):
        save_path += 'index.html'
        print('3-', save_path)
    if os.path.exists(save_path):
        return save_path

    # 해당 경로의 데렉토리가 없으면 생성
    save_dir = os.path.dirname(save_path)
    if not os.path.exists(save_dir):
        os.makedirs(save_dir)

    try:
        request.urlretrieve(url, save_path)
        time.sleep(1)
        return save_path
    except:
        print('download failed', url)
        return None


if __name__ == '__main__':
    url = 'https://docs.python.org/3.6/library/'
    result = download_file(url)
    print('=' * 20)
    print(result)



