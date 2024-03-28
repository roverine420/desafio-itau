package com.itau.desafio.Unibanco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itau.desafio.Unibanco.dto.EstatisticaResponse;
import com.itau.desafio.Unibanco.dto.TransacaoRequest;
import com.itau.desafio.Unibanco.service.TransacaoService;

@RestController
public class TransacaoController {

	@Autowired
	TransacaoService transacaoservice;
	
	@PostMapping("/transacao")
	public ResponseEntity<Void> enviarValores(@RequestBody TransacaoRequest requisicao) {
	   
		if (transacaoservice.enviarValor(requisicao)) {
	        return ResponseEntity.status(HttpStatus.CREATED).build();
	    } else {
	        return ResponseEntity.badRequest().build();
	    }
	}
	@DeleteMapping("/transacao")
	public void limparRegistros() {
		transacaoservice.limparValores();
	}
	
	@GetMapping("/transacao")
	public ResponseEntity<EstatisticaResponse> estatistica(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(transacaoservice.estatisticas());
	}
}
