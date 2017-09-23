# -*- coding:cp936 -*-

import json

path='D:\\new\\tool\\companyApp\\shell\\pydata-book\\ch02\\usagov_bitly_data2012-03-16-1331923249.txt'

with open(path,'r') as p:
    print(p.readline())

# Json ģ�齫����ת��Ϊ�ֵ�
records =  [json.loads(line) for line in open(path, 'r')]
print(records[0]['tz'])
print(type(records))

# ��ʱ�����м���

time_zones = [line['tz'] for line in records if 'tz' in line]
print(time_zones[:10])
print(len(time_zones))


def get_counts(seq):
    counts = {}
    for x in seq:
        if x not in counts:
            counts[x] =1
        else:
            counts[x] += 1
    return counts
print(get_counts(time_zones)['America/New_York'])

from collections import defaultdict
def get_counts2(seq):
    counts = defaultdict(int)
    for x in seq:
        counts[x] +=1
    return counts


print(get_counts2(time_zones)['America/New_York'])

# ��ȡ������top10
def get_top(count_dist, n = 10):
    value_key_pairs = [ (count, key) for key, count in count_dist.items()]
    value_key_pairs.sort()
    return value_key_pairs[-n:]

print(get_top(get_counts2(time_zones)), 10)


# ����python�ļ�����
from collections import Counter
counts = Counter(time_zones)
print(counts.most_common(10))


# ʹ��pandas���з���
from pandas import DataFrame, Series

import pandas as pd
import numpy as np

fream = DataFrame(records)

print(fream.head(1))

print(fream['tz'][:10])

tz_counts = fream['tz'].value_counts()
print(tz_counts[:10])


# fillna �滻Na None  '' �������ж��滻   dropna,fillna,isnull,notnull
clean_tz = fream['tz'].fillna('Missing')
clean_tz[clean_tz==''] = 'Unknown'
print(clean_tz)

clean_tz_counts=clean_tz.value_counts()
print(clean_tz_counts[:10])

# ��ͼ

clean_tz_counts[:10].plot(kind='barh', rot=0)

# ��ȡ����� agent  a��
results=Series( [ x.split()[0] for x in fream['a'].dropna()])
print(results[:5])

# window��

cfream = fream[fream.a.notnull()]
operating_system = np.where(cfream['a'].str.contains('Windows'), 'Windows', 'Not Windows')
print(operating_system[:5])