package com.itau.desafio.Unibanco.model;

import java.time.OffsetDateTime;

public class TransacaoModel {

	private float valor;
	private OffsetDateTime dataHora;
	
	
	
	public TransacaoModel() {
	}
	
	public TransacaoModel(float valor, OffsetDateTime dataHora) {
		this.valor = valor;
		this.dataHora = dataHora;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public OffsetDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(OffsetDateTime dataHora) {
		this.dataHora = dataHora;
	}
	
}
