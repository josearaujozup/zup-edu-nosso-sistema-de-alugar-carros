package br.com.zup.edu.alugacarzup.carro;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

public interface CarroRepository extends JpaRepository<Carro,Long> {
//	@Lock(LockModeType.PESSIMISTIC_WRITE)
//	Optional<Carro> findById(Long id);
}
