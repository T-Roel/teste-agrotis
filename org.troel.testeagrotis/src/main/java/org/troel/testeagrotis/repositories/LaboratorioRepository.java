package org.troel.testeagrotis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.troel.testeagrotis.entities.Laboratorio;

public interface LaboratorioRepository extends JpaRepository<Laboratorio, Long> {
	
}
