from collections import OrderedDict
from os.path import dirname, join
from pkgutil import get_data
import pandas as pd
import numpy as np
from itertools import combinations


class Lotto():
    def helloworld(name):
        return str('Hello my world 2 ' + name)

    def readAll(self):
        csvPath = join(dirname(__file__), 'Dataset/Lotto_10.csv')
        with open(csvPath,encoding='windows-1255') as f:
            records = []
            for line in f:
                row = line.strip().split(',')
                records.append(row)

        data = pd.DataFrame(records)
        # data = open(join(dirname(__file__),'Dataset/Lotto_10.csv'))
        # readme_bytes = get_data(__name__, "Dataset/Lotto_10.csv")
        # data = pd.read_csv("Dataset/Lotto_10.csv", encoding='windows-1255')
        # print(data.iloc[:,2:8])
        # row = pd.concat([data.iloc[:, 2], data.iloc[:, 3], data.iloc[:, 4]])
        # print(data.iloc[2:5,:])
        return data.iloc[:, :]

    def getCombinations(self, dataset):
        numbers = pd.DataFrame(dataset.iloc[:, 2:8])
        sortedNumbers = numbers.apply(np.sort, axis=1)
        allCombinations_1 = list(combinations(sortedNumbers[0], 2))

        print(allCombinations_1)
        return allCombinations_1

    def run(self):
        l = Lotto()
        dataset = l.readAll()
        return l.getCombinations(dataset)
        # for index,record in dataset.iterrows():
        #     print(record)


# Lotto().run()
