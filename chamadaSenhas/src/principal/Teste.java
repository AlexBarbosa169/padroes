package principal;

import java.util.Scanner;

import listaFichas.ListaFichas;
import modelo.Ficha;

public class Teste {

	private static Scanner entrada;
	private static Ficha removida;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaFichas lf = new ListaFichas();
		int incremento[] = { 1, 1, 1, 1 };		

		entrada = new Scanner(System.in);
		int a;
		do {
			System.out.println("Digite uma opção: ");
			System.out.println("1 - Nova Ficha PRE.\n");
			System.out.println("2 - Nova Ficha PFE.\n");
			System.out.println("3 - Nova Ficha NRE.\n");
			System.out.println("4 - Nova Ficha NFE.\n");
			System.out.println("5 - Chamar Fichas.\n");
			System.out.println("6 - Alterar Criterio de chamada das fichas.\n");
			System.out.println("0 - Sair.\n");
			a = entrada.nextInt();
			switch (a) {
			case 1:				
				Ficha f = new Ficha(incremento[0]++, "PRE");
				lf.adicionarFicha(f);
				System.out.println("Nova Ficha: " + f);
				break;
			case 2:				
				Ficha f1 = new Ficha(incremento[1]++, "PFE");
				lf.adicionarFicha(f1);
				System.out.println("Nova Ficha: " + f1);
				break;
			case 3:				
				Ficha f2 = new Ficha(incremento[2]++, "NRE");
				lf.adicionarFicha(f2);
				System.out.println("Nova Ficha: " + f2);
				break;
			case 4:				
				Ficha f3 = new Ficha(incremento[3]++, "NFE");
				lf.adicionarFicha(f3);
				System.out.println("Nova Ficha: " + f3);
				break;
			case 5:
				if((removida = lf.getCriterio().puxaFicha(lf)) != null) {
					System.out.println("Removida a " + removida);
				}
//				System.out.println("Removida a " + lf.getCriterio().puxaFicha(lf));				
				break;
			case 6:
				System.out.println("Qual critério adotar agora?\n");
				System.out.println("1 - Critério: NRE NFE NRE NFE PRE PFE\n");
				System.out.println("2 - Critério: NRE NRE NRE NFE NFE PRE PFE\n");
				System.out.println("3 - Critério: PRE PFE NRE NFE\n");
				System.out.println("4 - Critério: NRE NRE NRE PFE NFE NFE PFE\n");
				a = entrada.nextInt();
				lf.setCriterio(a);
				break;
			case 0:
				System.out.println("\n--------------- Aplicação Terminada ---------------\n");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}

			System.out.println(lf.toString());
			System.out.println("Sequencia!\n" + lf.getCriterio().getSequencia() + "\n");

		} while (a != 0);

	}

}
