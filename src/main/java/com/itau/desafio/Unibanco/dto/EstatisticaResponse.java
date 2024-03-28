package com.itau.desafio.Unibanco.dto;

public class EstatisticaResponse {

	private int count;
	private float sum;
	private float avg;
	private float min;
	private float max;
	
	
	
	public EstatisticaResponse() {
		
	}
	
	public EstatisticaResponse(int count, float sum, float avg, float min, float max) {
		this.count = count;
		this.sum = sum;
		this.avg = avg;
		this.min = min;
		this.max = max;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getSum() {
		return sum;
	}
	public void setSum(float sum) {
		this.sum = sum;
	}
	public float getAvg() {
		return avg;
	}
	public void setAvg(float avg) {
		this.avg = avg;
	}
	public float getMin() {
		return min;
	}
	public void setMin(float min) {
		this.min = min;
	}
	public float getMax() {
		return max;
	}
	public void setMax(float max) {
		this.max = max;
	}
	
}
