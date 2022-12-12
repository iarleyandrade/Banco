package model;

public class Composicao extends GenericModel {
	private int exame_id;

	
	
	
	
	public Composicao(int exame_id) {
		super();
		this.exame_id = exame_id;
	}

	public Composicao(int id, int exame_id) {
		setId(id);
		this.exame_id = exame_id;
	}



	public int getExame_id() {
		return exame_id;
	}





	@Override
	public String toString() {
		return "composicao [exame_id=" + exame_id + "]";
	}
	
}
