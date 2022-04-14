package org.troel.testeagrotis.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.troel.testeagrotis.entities.InfosPropriedade;
import org.troel.testeagrotis.entities.Laboratorio;
import org.troel.testeagrotis.entities.TelaTeste;
import org.troel.testeagrotis.repositories.InfosPropriedadeRepository;
import org.troel.testeagrotis.repositories.LaboratorioRepository;
import org.troel.testeagrotis.repositories.TelaTesteRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private InfosPropriedadeRepository infosPropriedadeRepository;
	
	@Autowired
	private LaboratorioRepository laboratorioRepository;
	
	@Autowired
	private TelaTesteRepository telaTesteRepository;
	
	@Override
	public void run(String... args) throws Exception {
		TelaTeste teste1 = new TelaTeste(null, "Carlos Caetano", Instant.parse("2021-01-15T19:53:07Z"), Instant.parse("2022-01-15T09:53:07Z"), "10.537.452/0001-60", "Controlador de Estoques");
		TelaTeste teste2 = new TelaTeste(null, "Rogério Machado", Instant.parse("2020-01-15T19:53:07Z"), Instant.parse("2022-04-15T09:53:07Z"), "27.938.647/0001-15", "Resíduos");
		TelaTeste teste3 = new TelaTeste(null, "Adelino Gomes", Instant.parse("2021-10-15T19:53:07Z"), Instant.parse("2022-01-15T09:53:07Z"), "40.442.298/0001-04", "Gerente de Projetos");
		TelaTeste teste4 = new TelaTeste(null, "Antonieta Lima", Instant.parse("2014-01-15T19:53:07Z"), Instant.parse("2021-10-21T09:53:07Z"), "53.693.620/0001-10", "DevOps");
		TelaTeste teste5 = new TelaTeste(null, "Novaes Pereira", Instant.parse("2022-01-15T19:53:07Z"), Instant.parse("2022-03-15T09:53:07Z"), "80.237.302/0001-17", "Estagiário");
		
		telaTesteRepository.saveAll(Arrays.asList(teste1, teste2, teste3, teste4, teste5));
		
		Laboratorio lab1 = new Laboratorio(null, "LCSM", teste1);
		Laboratorio lab2 = new Laboratorio(null, "ICMA", teste2);
		Laboratorio lab3 = new Laboratorio(null, "RBCM", teste3);
		Laboratorio lab4 = new Laboratorio(null, "ULVB", teste4);
		Laboratorio lab5 = new Laboratorio(null, "LENAM", teste5);
		
		laboratorioRepository.saveAll(Arrays.asList(lab1, lab2, lab3, lab4, lab5));
		
		InfosPropriedade info1 = new InfosPropriedade(null, "Fazenda São João", teste1);
		InfosPropriedade info2 = new InfosPropriedade(null, "Fazenda Nova Esperança", teste2);
		InfosPropriedade info3 = new InfosPropriedade(null, "Fazenda Santa Cruz", teste3);
		InfosPropriedade info4 = new InfosPropriedade(null, "Fazenda Rancho Divino", teste4);
		InfosPropriedade info5 = new InfosPropriedade(null, "Fazenda Boa Vila", teste5);
		
		infosPropriedadeRepository.saveAll(Arrays.asList(info1, info2, info3, info4, info5));
	}
}
