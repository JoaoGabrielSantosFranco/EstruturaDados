import pandas as pd
from matplotlib import pyplot as plt

plt.rcParams["figure.figsize"] = [7.00, 3.50]
plt.rcParams["figure.autolayout"] = True

columns = ['Sequencial', 'Sentinela', 'Binaria', 'Interpolacao']

df = pd.read_csv("output.csv", usecols=columns, sep=";")
df.plot()

plt.yscale("log")
plt.show()