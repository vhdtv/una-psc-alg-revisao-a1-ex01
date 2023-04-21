package sintaxe_basica;
import java.util.Scanner;
public class DiagnosticoCovid {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			boolean ViajouparaExterior = false, SintomasRecentes = false, CartaodeVacinaemDia = false;
			int opcao = 0, contador = 0, SomaPorcentagemdeInfeccao = 0, Idade;
			System.out.println("Digite o seu nome:");
			String Nome = scan.next();
			System.out.println("Digite a sua idade:");
			Idade = scan.nextInt();
			System.out.printf("Responda as perguntas a seguir:\n1 - Sim\n2 - Não\n");
			while (contador < 3 && contador >= 0) {
				System.out.println("Seu cartão de vacina está em dia?");
				opcao = scan.nextInt();
				switch (opcao) {
				case 1:
					CartaodeVacinaemDia = true;
					contador = -1;
					break;
				case 2:
					contador = -1;
					SomaPorcentagemdeInfeccao += 10;
					break;
				default:
					System.out.printf("Opcão invalida.\n");
					contador++;
					break;
				}
				if (contador >= 3) {
					System.out.println(
							"Não foi possível realizar o diagnóstico.\nGentileza procura assistência médica caso apareça algum sintoma.\n");
					return;
				}
			}
			contador = 0;
			while (contador < 3 && contador >= 0) {
				System.out.println(
						"Teve algum dos sintomas recentemente? " + "(dor de cabeça, febre, náusea, dor articular, gripe)");
				opcao = scan.nextInt();
				switch (opcao) {
				case 1:
					contador = -1;
					SintomasRecentes = true;
					SomaPorcentagemdeInfeccao += 30;
					break;
				case 2:
					contador = -1;
					break;
				default:
					System.out.printf("Opcão invalida.\n");
					contador++;
					break;
				}
				if (contador >= 3) {
					System.out.println(
							"Não foi possível realizar o diagnóstico.\nGentileza procura assistência médica caso apareça algum sintoma.\n");
					return;
				}
			}
			contador = 0;
			while (contador < 3 && contador >= 0) {
				System.out.println("Teve contato com pessoas com sintomas gripais nos últimos dias?");
				opcao = scan.nextInt();
				switch (opcao) {
				case 1:
					contador = -1;
					SomaPorcentagemdeInfeccao += 30;
					break;
				case 2:
					contador = -1;
					break;
				default:
					System.out.printf("Opcão invalida.\n");
					contador++;
					break;
				}
				if (contador >= 3) {
					System.out.println(
							"Não foi possível realizar o diagnóstico.\nGentileza procura assistência médica caso apareça algum sintoma.\n");
					return;
				}
			}
			contador = 0;
			while (contador < 3 && contador >= 0) {
				System.out.println("Está retornando de viagem realizada no exterior?");
				opcao = scan.nextInt();
				switch (opcao) {
				case 1:
					contador = -1;
					SomaPorcentagemdeInfeccao += 30;
					ViajouparaExterior = true;
					break;
				case 2:
					contador = -1;
					break;
				default:
					System.out.printf("Opcão invalida.\n");
					contador++;
					break;
				}
				if (contador >= 3) {
					System.out.println(
							"Não foi possível realizar o diagnóstico.\nGentileza procura assistência médica caso apareça algum sintoma.\n");
					return;
				}
			}
			System.out.print("Nome:" + Nome);
			System.out.println("\nIdade:" + Idade);
			if (CartaodeVacinaemDia == true)
				System.out.println("Cartão de vacina está em dia.");
			if (SintomasRecentes == true)
				System.out.println("O usuário apresentou sintomas recentes.");
			if (ViajouparaExterior == true)
				System.out.println("O usuário está retornado de viagem.");
			System.out.printf("A probabilida do usuário estar infectado é:%d%%.\n", SomaPorcentagemdeInfeccao);
			if (SomaPorcentagemdeInfeccao <= 30)
				System.out.println(
						"Paciente sob observação. Caso apareça algum sintoma, gentileza buscar assistência médica.");
			else if (SomaPorcentagemdeInfeccao <= 60)
				System.out.println(
						"Paciente com risco de estar infectado. Gentileza aguardar em lockdown por 02 dias para ser acompanhado.");
			else if (SomaPorcentagemdeInfeccao >= 90)
				System.out.println("Paciente crítico! Gentileza aguardar em lockdown por 10 dias para ser acompanhado.");
			else if (ViajouparaExterior == true)
				System.out.println("Você ficará sob observação por 05 dias.");
		}
	}
}
