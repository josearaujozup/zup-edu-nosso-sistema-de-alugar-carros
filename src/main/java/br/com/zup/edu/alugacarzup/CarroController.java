package br.com.zup.edu.alugacarzup;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.edu.alugacarzup.carro.Carro;
import br.com.zup.edu.alugacarzup.carro.CarroRepository;

@RestController
@RequestMapping("/carros")
public class CarroController {
	
	private final CarroRepository repository;

	public CarroController(CarroRepository repository) {
		super();
		this.repository = repository;
	}
	
	
	@PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizar(@PathVariable("id") Long idCarro, @RequestBody @Valid AluguelDTO request){
		
		Carro carro = repository.findById(idCarro).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Carro não encontrado"));
		
		if(!carro.isDisponivel()) {
    		throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"carro já reservada");
    	}
		
		carro.alugar(request.getReservadoPara());
		
		repository.save(carro);
    	
    	return ResponseEntity.noContent().build();
		
	}
    
	
}
