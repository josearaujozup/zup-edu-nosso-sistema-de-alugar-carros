package br.com.zup.edu.alugacarzup.carro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private Integer ano;

    @Column(nullable = false)
    private String marca;
    
    @Column
    private String reservadoPara;

    @Column(nullable = false)
    private boolean disponivel;

    public Carro(String modelo, Integer ano, String marca) {
        this.modelo = modelo;
        this.ano = ano;
        this.marca = marca;
        this.disponivel=true;
    }

    /**
     * @deprecated construtor para uso exclusivo do Hibernate
     */
    @Deprecated
    public Carro() {
    }

    public Long getId() {
        return id;
    }
    
	public boolean isDisponivel() {
		return this.disponivel == true;
	}

	public void alugar(String reservadoPara) {
		this.reservadoPara = reservadoPara;
		this.disponivel = false;
	}
}
