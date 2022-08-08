import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("output.csv")));

        int n = 1000;
        int repeticoes = 50;

        writer.write("N;Sequencial;Sentinela;Binaria;Interpolacao\n");

        for (int i = 1; i <= n; i++) {
            int somaSequencial = 0;
            int somaSequencialSentinela = 0;
            int somaPesquisaBinaria = 0;
            int somaPesquisaInterpolacao = 0;
            
            for (int j = 0; j < repeticoes; j++) {
                int v[] = Pesquisa.vetorAleatorio(i);
                int chave = v[((int) (Math.random() * i))];
                
                somaSequencial += Pesquisa.pesquisaSequencial(chave, v);
                somaSequencialSentinela += Pesquisa.pesquisaSequencialSentinela(chave, v);

                Classificacao.quicksort(v);
                
                somaPesquisaBinaria += Pesquisa.pesquisaBinaria(chave, v);
                somaPesquisaInterpolacao += Pesquisa.pesquisaBinaria(chave, v);
            }
            
            writer.write(i + ";" + 
                (somaSequencial / repeticoes) + ";" + 
                (somaSequencialSentinela / repeticoes) + ";" + 
                (somaPesquisaBinaria / repeticoes) + ";" +
                (somaPesquisaInterpolacao / repeticoes) + "\n");
        }

        writer.close();
    }
}
