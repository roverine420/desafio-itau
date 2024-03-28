package com.itau.desafio.Unibanco.service;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.itau.desafio.Unibanco.dto.EstatisticaResponse;
import com.itau.desafio.Unibanco.dto.TransacaoRequest;
import com.itau.desafio.Unibanco.model.TransacaoModel;


@Service
public class TransacaoService {

	List<TransacaoModel> listaTransacao = new ArrayList<>();
	
	public boolean enviarValor(@RequestBody TransacaoRequest requisicao) {
		
		System.out.println("Processando valores enviados");
		if (requisicao == null || requisicao.getDataHora() == null) {
	        return false;
	    }
		OffsetDateTime agora = OffsetDateTime.now();
	    OffsetDateTime dataHoraRequisicao = requisicao.getDataHora(); 
	    System.out.println("Verificando data informada");
	    if (dataHoraRequisicao.isAfter(agora)) {
	        return false; // Retorna falso se a requisição estiver no futuro
	    }    
	    // Adiciona à lista apenas se a requisição estiver no passado ou agora
	    if (requisicao.getValor() >= 0) {
	        TransacaoModel objtransacao = new TransacaoModel(requisicao.getValor(), dataHoraRequisicao);
	        listaTransacao.add(objtransacao);
	        System.out.println("adicionado a lista de transacoes");
	        return true;
	    }
	    return false; // Retorna falso se o valor for negativo
	}
	
	public void limparValores() {
		System.out.println("Limpando dados da lista");
		listaTransacao.clear();
	}
	public EstatisticaResponse estatisticas() {
	    System.out.println("Atribuindo valores");
	    int qtdTransacoes = 0;
	    float somaValores = 0;
	    float mediaValores = 0;
	    float maiorValor = 0;
	    float menorValor = 0;

	    OffsetDateTime agora = OffsetDateTime.now();

	    for (TransacaoModel transacaomodel : listaTransacao) {
	        // Verifica se a transação ocorreu nos últimos 60 segundos
	        OffsetDateTime dataHoraTransacao = transacaomodel.getDataHora();
	        long segundosDecorridos = ChronoUnit.SECONDS.between(dataHoraTransacao, agora);
	        if (segundosDecorridos <= 60) {
	            qtdTransacoes += 1;
	            somaValores += transacaomodel.getValor();
	            if (maiorValor <= transacaomodel.getValor()) {
	                System.out.println("Definindo maior valor");
	                maiorValor = transacaomodel.getValor();
	            }
	            if (menorValor >= transacaomodel.getValor() || menorValor == 0) {
	                System.out.println("Definindo menor valor");
	                menorValor = transacaomodel.getValor();
	            }
	        }
	    }

	    if (somaValores == 0 && qtdTransacoes == 0) {
	        System.err.println("Valores zerados, nao foi possivel realizar a divisao");
	        mediaValores = 0;
	    } else {
	        System.out.println("Calculando valor medio");
	        mediaValores = somaValores / qtdTransacoes;
	    }

	    System.out.println("Processando retorno");
	    EstatisticaResponse retorno = new EstatisticaResponse(qtdTransacoes, somaValores, mediaValores, menorValor, maiorValor);
	    return retorno;
	}
	
}
