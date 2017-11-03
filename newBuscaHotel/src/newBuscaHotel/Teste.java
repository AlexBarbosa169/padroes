package newBuscaHotel;

import modelo.Hotel;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Controlador c = new Controlador();
//		Construtor : Hotel(Nome,Cidade,distCentro,qSimples,qDuplo,qTriplo,qPresidencial)
		
		geraHoteis(c);
		
		try {
//			c.adicionarReserva(nomeHotel, tipoQuarto, inicioHospedagem, fimHospedagem, tipoPagamento);
			c.adicionarReserva("Cabo Branco", "Simples", "12/10/2017", "14/10/2017", "Cartão");
			c.adicionarReserva("Cabo Branco", "Simples", "12/11/2017", "13/11/2017", "Boleto");
			c.adicionarReserva("Cabo Branco", "Simples", "9/10/2017", "11/10/2017", "Cartão");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		try {
//			c.adicionarReserva("Tambau", "Simples", 3, 4, 1);
//			c.adicionarReserva("Tambau", "Simples", 3, 4, 1);
//			c.adicionarReserva("Tambau", "Simples", 3, 6, 1);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
				
		System.out.println(c.buscaHoteisNome("João Pessoa", "Simples", "12/10/2017", "14/10/2017"));
		System.out.println(c.buscaHoteisNome("Campina Grande", "Simples", "12/10/2017", "14/10/2017"));
		System.out.println(c.buscaHoteisPreco("João Pessoa", "Simples", "12/10/2017", "14/10/2017"));
		System.out.println(c.buscaHoteisPreco("João Pessoa", "Duplo", "12/10/2017", "14/10/2017"));
		System.out.println(c.buscaHoteisDistancia("João Pessoa", "Duplo", "12/10/2017", "14/10/2017"));
		System.out.println(c.buscaHoteisRecomendacao("Campina Grande", "Simples", "12/10/2017", "14/10/2017"));
		
		System.out.println(c.reservasHotel("Tambau"));
		System.out.println(c.reservasHotel("Cabo Branco"));
		
	}
	
	static void geraHoteis(Controlador c) {
		Hotel h1 = new Hotel("Tambau", "João Pessoa", 5.5f, 120f, 200f, 300f, 400f);
		Hotel h2 = new Hotel("Cabo Branco", "João Pessoa", 4.5f, 110f, 220f, 330f, 440f);
		Hotel h3 = new Hotel("Bessa", "João Pessoa", 3.5f,115f, 225f, 335f, 445f);
		Hotel h4 = new Hotel("Cruzeiro", "Campina Grande", 2.5f,150f, 250f, 350f, 450f);
		Hotel h5 = new Hotel("Alto Branco", "Campina Grande", 5.5f, 120f, 200f, 300f, 400f);
		Hotel h6 = new Hotel("Açude", "Campina Grande", 4.5f, 110f, 220f, 330f, 440f);
		Hotel h7 = new Hotel("Tibiri", "Santa rita", 3.5f,115f, 225f, 335f, 445f);
		Hotel h8 = new Hotel("Boa Vista", "Santa rita", 2.5f,150f, 250f, 350f, 450f);
		
		/*h1.setSimples(150f);
		h2.setSimples(110f);
		h3.setSimples(120f);
		h4.setSimples(130f);*/
		
		h1.adicionarQuarto("Simples");
		h1.adicionarQuarto("Simples");
		h1.adicionarQuarto("Duplo");
		h1.adicionarQuarto("Duplo");
		
		h2.adicionarQuarto("Simples");
		h2.adicionarQuarto("Simples");
		h2.adicionarQuarto("Duplo");
		h2.adicionarQuarto("Duplo");
		
		h3.adicionarQuarto("Simples");
		h3.adicionarQuarto("Simples");
		h3.adicionarQuarto("Duplo");
		h3.adicionarQuarto("Triplo");
		
		h4.adicionarQuarto("Simples");
		h4.adicionarQuarto("Simples");
		h4.adicionarQuarto("Duplo");
		h4.adicionarQuarto("Triplo");
		
		h5.adicionarQuarto("Simples");
		h5.adicionarQuarto("Simples");
		h5.adicionarQuarto("Duplo");
		h5.adicionarQuarto("Triplo");
		
		h6.adicionarQuarto("Simples");
		h6.adicionarQuarto("Simples");
		h6.adicionarQuarto("Duplo");
		h6.adicionarQuarto("Triplo");
		
		h7.adicionarQuarto("Simples");
		h7.adicionarQuarto("Simples");
		h7.adicionarQuarto("Duplo");
		h7.adicionarQuarto("Triplo");
		
		h8.adicionarQuarto("Simples");
		h8.adicionarQuarto("Simples");
		h8.adicionarQuarto("Duplo");
		h8.adicionarQuarto("Triplo");
		
		c.adicionarHoteis(h1);
		c.adicionarHoteis(h2);
		c.adicionarHoteis(h3);
		c.adicionarHoteis(h4);
		c.adicionarHoteis(h5);
		c.adicionarHoteis(h6);
		c.adicionarHoteis(h7);
		c.adicionarHoteis(h8);
	}

}
