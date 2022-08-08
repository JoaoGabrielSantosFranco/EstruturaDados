public class main {
    public static int[] bubblesort1(int v[]) {
        int count = 0;

        for (int i = 0; i < v.length - 1; i++) {
            for (int j = i + 1; j < v.length; j++) {
                count++;
                if (v[i] > v[j]) {
                    int aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                }
            }
        }
        System.out.print("," + count);
        return v;
    }

    public static int[] bubblesort2(int v[]) {
        boolean troca;
        do {
            troca = false;
            for (int i = 0; i < v.length - 1; i++) {
                if (v[i] > v[i + 1]) {
                    int aux = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = aux;
                    troca = true;
                }
            }
        } while (troca);
        return v;
    }

    public static int[] insertionsort(int v[]) {
        int count = 0;
        int pivo, j;
        for (int i = 1; i < v.length; i++) {
            count++;
            pivo = v[i];
            j = i - 1;
            while (j >= 0 && pivo < v[j]) {
                count++;
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = pivo;
        }
        System.out.print("," + count);
        return v;
    }

    public static void mergesort(int v[]) {
        mergesort(v, 0, v.length - 1);
    }

    public static void mergesort(int v[], int inicio, int fim) {
        int meio = (inicio + fim) / 2;

        if (inicio < fim) {
            mergesort(v, inicio, meio);
            mergesort(v, meio + 1, fim);

            merge(v, inicio, meio, fim);
        }
    }

    public static void merge(int v[], int inicio, int meio, int fim) {
        int aux[] = new int[(fim + 1) - inicio];
        int i = inicio, j = meio + 1, k = 0;

        while (i <= meio && j <= fim) {
            aux[k++] = v[i] <= v[j] ? v[i++] : v[j++];
        }

        while (i <= meio) {
            aux[k++] = v[i++];
        }

        while (j <= fim) {
            aux[k++] = v[j++];
        }

        for (i = inicio, k = 0; i <= fim; i++, k++) {
            v[i] = aux[k];
        }
    }

    public static void mergesortBU(int v[]) {
        mergesortBU(v, 0, v.length - 1);
    }

    public static void mergesortBU(int v[], int inicio, int fim) {
        int i, meio;

        for (meio = 1; meio < fim - inicio + 1; meio = 2 * meio) {
            for (i = inicio; i <= fim - meio; i += 2 * meio) {
                int j = (i + (2 * meio)) - 1;
                if (j > fim)
                    j = fim;

                merge(v, i, i + meio - 1, j);
            }
        }
    }

    public static void quicksort(int v[]) {
        quicksort(v, 0, v.length - 1);
    }

    public static void quicksort(int v[], int inicio, int fim) {
        if (inicio < fim) {
            int meio = partition(v, inicio, fim);

            quicksort(v, inicio, meio - 1);
            quicksort(v, meio + 1, fim);
        }
    }

    public static void swap(int v[], int i, int j) {
        int aux = v[j];
        v[j] = v[i];
        v[i] = aux;
    }

    public static int partition(int v[], int inicio, int fim) {
        int pivo = v[fim];
        int i = (inicio - 1);

        for (int j = inicio; j <= fim - 1; j++) {
            if (v[j] < pivo) {
                i++;

                swap(v, i, j);
            }
        }

        swap(v, i + 1, fim);

        return i + 1;
    }

    public static void heapify(int v[], int n, int i) {
        int raiz = i;
        count++;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < n && v[esquerda] > v[raiz])
            raiz = esquerda;

        if (direita < n && v[direita] > v[raiz])
            raiz = direita;

        if (raiz != i) {
            swap(v, i, raiz);
            heapify(v, n, raiz);
        }

    }

    static int count = 0;

    public static void heapsort(int v[]) {
        count = 0;

        for (int i = v.length / 2 - 1; i >= 0; i--) {
            heapify(v, v.length, i);

        }

        for (int i = v.length - 1; i > 0; i--) {

            swap(v, 0, i);
            heapify(v, i, 0);

        }
        System.out.print("," + count);
    }

    public static int max(int v[]) {
        int max = v[0];

        for (int i = 1; i < v.length; i++) {
            if (v[i] > max)
                max = v[i];
        }

        return max;
    }

    public static void countsort(int v[], int exp) {
        int output[] = new int[v.length], count[] = new int[10];

        for (int i = 0; i < v.length; i++) {
            count[(v[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = v.length - 1; i >= 0; i--) {
            output[count[(v[i] / exp) % 10] - 1] = v[i];
            count[(v[i] / exp) % 10]--;
        }

        for (int i = 0; i < v.length; i++) {
            v[i] = output[i];
        }
    }

    public static void radixsort(int v[]) {
        int max = max(v);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countsort(v, exp);
        }
    }

    public static void coutingsort(int v[]) {
        int output[] = new int[v.length];

        int count[] = new int[max(v) + 1];

        for (int i = 0; i < v.length; i++)
            count[v[i]]++;

        for (int i = 1; i < count.length; ++i)
            count[i] += count[i - 1];

        for (int i = v.length - 1; i >= 0; i--) {
            output[count[v[i]] - 1] = v[i];
            --count[v[i]];
        }

        for (int i = 0; i < v.length; ++i)
            v[i] = output[i];
    }

    public static int[] worstcase(int n) {
        int v[] = new int[n];

        for (int i = 0; i < n; i++) {
            v[i] = n - i;
        }

        return v;
    }

    public static int[] bestcase(int n) {
        int v[] = new int[n];

        for (int i = 0; i < n; i++) {
            v[i] = i;
        }

        return v;
    }

    public static int[] averagecase(int n) {
        int v[] = new int[n];

        for (int i = 0; i < n; i++) {
            v[i] = (int) (Math.random() * n);
        }

        return v;

    }

    public static int PesquisaBinaria(int chave, int v[]) {
        int contador = 0;
        int inicio = 0, meio, fim = v.length - 1;
        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            contador += 1;
            if (chave < v[meio]) {
                fim = meio - 1;
            } else if (chave > v[meio]) {
                inicio = meio + 1;
            } else {
                System.out.println(contador);
                System.out.println("Encontrou o numero " + meio + " Apos " + contador);
                return meio;
            }

        }
        System.out.println(contador);
        return -1;
    }

    public static int[] melhor(int n) {
        int v[] = new int[n];

        for (int i = 0; i < n; i++) {
            v[i] = i;
        }

        return v;
    }

    public static int pesquisaSequencialSentinela(int chave, int v[]) {
        int contador = 1;
        int i = 0;
        int c[] = new int[v.length + 1];
        System.arraycopy(v, i, c, i, v.length);
        c[v.length] = chave; // A última posição do vetor possui o sentinela
        while (c[i] != chave) {
            contador++;
            i++;
        }
        if (i < v.length)
            return i;
        System.out.println(contador);
        return -1; // Índice inválido
    }

    public static int pesquisaSequencial(int chave, int v[]) {
        int contador = 0;
        for (int i = 0; i < v.length; i++) {
            contador += 2;
            if (v[i] == chave) {

                System.out.println(contador);
                return i;
            }
        }
        System.out.println(contador);
        return -1; // índice inválido
    }

    public static int pesquisaInterpolacao(int chave, int v[]) {
        int contador = 1;
        int ini = 0, meio, fim = v.length - 1;
        while (ini <= fim && chave >= v[ini] && chave <= v[fim]) {
            
            meio = ini + ((fim - ini) * (chave - v[ini])) / (v[fim] - v[ini]);
            if (chave < v[meio]) {
                fim = meio - 1;
            } else if (chave > v[meio]) {
                ini = meio + 1;
            } else {
                return meio;
            }
            contador++;
        }
        System.out.println(contador);
        return -1; // Índice impossível
    }

    public static void main(String[] args) {
        /* 
        for (int i = 0; i < 1001; i += 10) {
            int avg[] = averagecase(i);

            System.out.print("PesquisaBinaria:" + "vetor tamanho " + i + "  :");
            PesquisaBinaria(2001, avg);
            System.out.println("");
        }

        for (int i = 0; i < 1001; i += 10) {
            int avg[] = averagecase(i);

            System.out.print("pesquisaSequencialSentinela:" + "vetor tamanho " + i + "  :");
            pesquisaSequencialSentinela(2001, avg);

        }

        for (int i = 0; i < 1001; i += 10) {
            int avg[] = averagecase(i);

            System.out.print("pesquisaSequencial:" + "vetor tamanho " + i + "  :");
            pesquisaSequencial(2001, avg);

        }
*/
       for (int i = 1; i < 10; i++) {
            int avg[] = bestcase(i);

            System.out.println("pesquisaInterpolacao:" + "vetor tamanho " + i + "  :" + pesquisaInterpolacao(2, avg));
            

        }
           
    }
}