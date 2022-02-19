package br.senai.sp.quiosquel.model;



	public enum FaixaEtaria {
		JOVEM("Jovem"), ADULTO("Adulto"), IDOSO("Idoso");
		
		String desc;
		FaixaEtaria(String string) {
			this.desc=string;
		}

		@Override
		public String toString() {
			// TODO Auto-generated constructor stub
			return this.desc;
		}
	}



