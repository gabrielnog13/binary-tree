package teste;
	import java.util.Scanner;

	class No {
	    int valor;
	    No esquerda, direita;

	    public No(int item) {
	        valor = item;
	        esquerda = direita = null;
	    }
	}

	class ArvoreBinaria {
	    No raiz;

	    ArvoreBinaria() {
	        raiz = null;
	    }

	    public void inserir(int chave) {
	        raiz = inserirRecursivo(raiz, chave);
	    }

	    private No inserirRecursivo(No no, int chave) {
	        if (no == null) {
	            no = new No(chave);
	            return no;
	        }

	        if (chave < no.valor)
	            no.esquerda = inserirRecursivo(no.esquerda, chave);
	        else if (chave > no.valor)
	            no.direita = inserirRecursivo(no.direita, chave);

	        return no;
	    }

	    public void remover(int chave) {
	        raiz = removerRecursivo(raiz, chave);
	    }

	    private No removerRecursivo(No no, int chave) {
	        if (no == null)
	            return no;

	        if (chave < no.valor)
	            no.esquerda = removerRecursivo(no.esquerda, chave);
	        else if (chave > no.valor)
	            no.direita = removerRecursivo(no.direita, chave);
	        else {
	            if (no.esquerda == null)
	                return no.direita;
	            else if (no.direita == null)
	                return no.esquerda;

	            no.valor = menorValor(no.direita);

	            no.direita = removerRecursivo(no.direita, no.valor);
	        }

	        return no;
	    }

	    private int menorValor(No raiz) {
	        int min = raiz.valor;
	        while (raiz.esquerda != null) {
	            min = raiz.esquerda.valor;
	            raiz = raiz.esquerda;
	        }
	        return min;
	    }

	    public void listar() {
	        imprimirArvore(raiz);
	    }

	    private void imprimirArvore(No no) {
	        if (no != null) {
	            imprimirArvore(no.esquerda);
	            System.out.print(no.valor + " ");
	            imprimirArvore(no.direita);
	        }
	    }
	}

	public class provaEd {
	    public static void main(String[] args) {
	        Scanner leia = new Scanner(System.in);
	        int opc = 0;
	        ArvoreBinaria arvore = new ArvoreBinaria();

	        while (opc != 4) {
	            System.out.println("");
	            System.out.println("## ÁRVORE BINÁRIA ##");
	            System.out.println("1 - Inserir");
	            System.out.println("2 - Remover");
	            System.out.println("3 - Listar");
	            System.out.println("4 - Sair");
	            System.out.println("");
	            System.out.print("Informe a opção desejada: ");
	            opc = leia.nextInt();
	            switch (opc) {
	                case 1:
	                    System.out.print("Informe o valor a inserir: ");
	                    int valorInserir = leia.nextInt();
	                    arvore.inserir(valorInserir);
	                    break;
	                case 2:
	                    System.out.print("Informe o valor a remover: ");
	                    int valorRemover = leia.nextInt();
	                    arvore.remover(valorRemover);
	                    break;
	                case 3:
	                    System.out.println("Elementos na árvore:");
	                    arvore.listar();
	                    System.out.println();
	                    break;
	                case 4:
	                    System.out.println("Saindo...");
	                    break;
	                default:
	                    System.out.println("Opção inválida!");
	                    break;
	            }
	        }
	    }
	}