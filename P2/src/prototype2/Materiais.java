package prototype2;

public class Materiais {
	
	String nome;
	
	public Materiais(String aNome) {
		this.nome = aNome;
		
	}
	
	public void Forge() {
		
		if (nome == "Cobre");
		System.out.println("Item forjado com sucesso.");
		 if (nome == "Prata");
		System.out.println("O item não pode ser forjado com o material, favor, selecionar outro material.");
		
		if (nome == "Bismuto");
		System.out.println( "Iten forjado, porém com material não recomendável.");
		
		if (nome == "Ferro");
		System.out.println("Item forjado com sucesso.");
		
		if (nome == "Cobalto");
		System.out.println("Item forjado, porém, não recomendado utilizar graças ao risco a saúde que o material proporciona.");
		
		
		if (nome == "chumbo");
		System.out.println("Material muito denso, não foi possível criar o item");
		
		if (nome == "Prata");
		System.out.println("Item forjado com sucesso, foi utilizado o melhor material recomendado.");
		
		
		
		
		
		
		
		
	}

}
