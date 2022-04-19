package br.com.zup.edu.alugacarzup;

import javax.validation.constraints.NotBlank;

public class AluguelDTO {
	
	@NotBlank
	private String reservadoPara;

	public AluguelDTO(@NotBlank String reservadoPara) {
		super();
		this.reservadoPara = reservadoPara;
	}
	
	public AluguelDTO() {
		
	}

	public String getReservadoPara() {
		return reservadoPara;
	}

}
