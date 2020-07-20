import requests
import json
import re
import jieba
import pandas as pd
import numpy
from wordcloud import WordCloud
import matplotlib.pyplot as plt
from os import path
import numpy as np
from PIL import Image
import urllib.parse
from lxml import etree


def get_good_info(keyword):
    """Get the list of comments with the input keyword"""
    if keyword is None or keyword == "":
        return ""

    all_comments = ""
    # First get the list of skus
    lst_skus = []

    for page in range(0, 201):
        print("Scrapping page ", page, "...")
        url_item_list = "https://search.jd.com/Search?keyword={0}&page={1}&enc=utf-8&suggest=2.his.0.0&wq=&pvid=9ff2a748ea5d40c9aef4f58ba921e7da".format(
            urllib.parse.quote(keyword), page)

        head = {'authority': 'search.jd.com',
                'method': 'GET',
                'path': '/s_new.php?keyword=%E6%89%8B%E6%9C%BA&enc=utf-8&qrst=1&rt=1&stop=1&vt=2&wq=%E6%89%8B%E6%9C%BA'
                        '&cid2=653&cid3=655&page=4&s=84&scrolling=y&log_id=1529828108.22071&tpl=3_M&show_items=7651927,'
                        '7367120,7056868,7419252,6001239,5934182,4554969,3893501,7421462,6577495,26480543553,7345757,'
                        '4483120,6176077,6932795,7336429,5963066,5283387,25722468892,7425622,4768461',
                'scheme': 'https',
                'referer': 'https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&enc=utf-8&qrst=1&rt=1&stop=1&vt=2&wq'
                           '=%E6%89%8B%E6%9C%BA&cid2=653&cid3=655&page=3&s=58&click=0',
                'user-agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) '
                              'Chrome/66.0.3359.139 Safari/537.36',
                'x-requested-with': 'XMLHttpRequest',
                'Cookie': 'qrsc=3; pinId=RAGa4xMoVrs; xtest=1210.cf6b6759; ipLocation=%u5E7F%u4E1C; _jrda=5; '
                          'TrackID=1aUdbc9HHS2MdEzabuYEyED1iDJaLWwBAfGBfyIHJZCLWKfWaB_KHKIMX9Vj9_2wUakxuSLAO9AFtB2U0SsAD'
                          '-mXIh5rIfuDiSHSNhZcsJvg; shshshfpa=17943c91-d534-104f-a035-6e1719740bb6-1525571955; '
                          'shshshfpb=2f200f7c5265e4af999b95b20d90e6618559f7251020a80ea1aee61500; cn=0; '
                          '3AB9D23F7A4B3C9B'
                          '=QFOFIDQSIC7TZDQ7U4RPNYNFQN7S26SFCQQGTC3YU5UZQJZUBNPEXMX7O3R7SIRBTTJ72AXC4S3IJ46ESBLTNHD37U; '
                          'ipLoc-djd=19-1607-3638-3638.608841570; __jdu=930036140; '
                          'user-key=31a7628c-a9b2-44b0-8147-f10a9e597d6f; areaId=19; '
                          '__jdv=122270672|direct|-|none|-|1529893590075; PCSYCityID=25; '
                          'mt_xid'
                          '=V2_52007VwsQU1xaVVoaSClUA2YLEAdbWk5YSk9MQAA0BBZOVQ0ADwNLGlUAZwQXVQpaAlkvShhcDHsCFU5eXENaGkIZWg5nAyJQbVhiWR9BGlUNZwoWYl1dVF0%3D; __jdc=122270672; shshshfp=72ec41b59960ea9a26956307465948f6; rkv=V0700; __jda=122270672.930036140.-.1529979524.1529984840.85; __jdb=122270672.1.930036140|85.1529984840; shshshsID=f797fbad20f4e576e9c30d1c381ecbb1_1_1529984840145 '
                }

        xba = requests.get(url_item_list, headers=head)
        xba.encoding = 'utf-8'
        html1 = etree.HTML(xba.text)

        # print(len(html1.xpath("//*[@id='J_bottomPage']/span")))
        # num_of_pages = int(etree.tostring(html1.xpath("//*[@id='J_bottomPage']/span[@class='p-skip']/em/b")[0], method="text"))
        num_of_pages = 200

        good_list = html1.xpath("//*[@id='J_goodsList']/ul/li")  # Only 1 item div[@id="J_goodsList"]
        idx = 0
        for good in good_list:
            # print(etree.tostring(good, encoding='unicode'))
            print(
                "===========================================================================================================")
            # Also some other information
            sku_id = good.get('data-sku')
            lst_skus.append(sku_id)

            ## etree BUG: xpath not relative to current node
            name = etree.tostring(good.xpath("//*[@class='p-name p-name-type-2']/a/em")[idx], encoding='unicode',
                                  method="text").rstrip()
            price = etree.tostring(good.xpath("//*[@class='p-price']/strong/i")[idx], encoding='unicode',
                                   method="text").rstrip()
            print("skuid: {0}, name: {1}, price: {2}".format(sku_id, name, price))

            idx += 1


    # print(lst_skus)
    return all_comments


# 数据清洗处理模块
# def data_clear():
#     xt = get_comments('手机')
#     pattern = re.compile(r'[\u4e00-\u9fa5]+')
#     filedata = re.findall(pattern, xt)
#     xx = ''.join(filedata)
#     clear = jieba.lcut(xx)  # 切分词
#     cleared = pd.DataFrame({'clear': clear})
#     stopwords = pd.read_csv("chineseStopWords.txt", index_col=False, quoting=3, sep="\t", names=['stopword'],
#                             encoding='GBK')
#     cleared = cleared[~cleared.clear.isin(stopwords.stopword)]
#     count_words = cleared.groupby(by=['clear'])['clear'].agg({"num": numpy.size})
#     count_words = count_words.reset_index().sort_values(by=["num"], ascending=False)
#     return count_words


# 词云展示模块
# def make_wordclound():
#     d = path.dirname(__file__)
#     msk = np.array(Image.open(path.join(d, "me.jpg")))
#     wordcloud = WordCloud(font_path="simhei.ttf", mask=msk, background_color="#EEEEEE", max_font_size=250, width=1300,
#                           height=800)  # 指定字体类型、字体大小和字体颜色
#     word_frequence = {x[0]: x[1] for x in data_clear().head(200).values}
#     wordcloud = wordcloud.fit_words(word_frequence)
#     plt.imshow(wordcloud)
#     plt.axis("off")
#     plt.show()


if __name__ == "__main__":
    get_good_info('手机')
    print("finish")
