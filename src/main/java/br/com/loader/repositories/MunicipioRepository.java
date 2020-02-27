package br.com.loader.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.loader.domain.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {

}
