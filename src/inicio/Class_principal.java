/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio;

import buscas.AEstrela;
import logica.No;
import estrutura.Busca;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tg
 */
public class Class_principal {

    private int proximo;
    private Busca busca;
    private No no;
    private List<logica.Celula> lista;
    private List<No> solucao;
    private int estado[][];

    /*
     * Configura os possíveis estados iniciais do quebra cabeça
     */

    public void estado_inicial_quebra_cabeca(int num) {
        int[][] quebra_cabeca = { { 1, 8, 2 }, { 0, 4, 3 }, { 7, 6, 5 } };
        estado = quebra_cabeca;
        no.setPai(null);
        no.setEstados(estado);
    }

    public Class_principal() {
        lista = new ArrayList<>();
        no = new No();
        proximo = 0;
    }

    public int escolher_estado_inicial() {

        Scanner ler = new Scanner(System.in);

        int opcao_estado_inicial;
        System.out.println("Estado inicial => {1, 8, 2}, {0, 4, 3}, {7, 6, 5}");
        opcao_estado_inicial = 1;

        return opcao_estado_inicial;
    }

    public int escolher_heuristica() {

        Scanner ler = new Scanner(System.in);

        int heuristica;
        System.out.println("Selecione a heuristica");
        System.out.println("Digite 0 para - Peças fora do lugar -");
        System.out.println("Digite 1 para - Distanciamento de Manhattan");
        heuristica = ler.nextInt();

        return heuristica;

    }

    public void menu() {

        Scanner ler = new Scanner(System.in);
        int n;
        int proximo;
        int estado_inicial;
        int heuristica;

        System.out.println("Busca em A*");

        n = 1;

        estado_inicial = escolher_estado_inicial();
        if (estado_inicial == 1) {
            estado_inicial_quebra_cabeca(0);
        } else if (estado_inicial == 2) {
            estado_inicial_quebra_cabeca(1);
        }
        heuristica = escolher_heuristica();
        if ((heuristica == 0) || (heuristica == 1)) {
            AEstrela estrela = new AEstrela();
            estrela.setHeuristica(heuristica);
            estrela.solucionar(no);
            System.out.println("Quantidade de nos expandidos: " + estrela.getContador());
            System.out.println("Total de movimentações: " + estrela.getMovimentos());
            solucao = estrela.getSolucao();
            estrela.setMovimentos(0);
            estrela.setContador(0);
        } else {
            System.out.println("Digite os numeros solicitados");

        }
    }

}
