package br.senai.sp.quiosquel.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Cliente {
	private Long id;
	private String nome;
	private String endereco;
	private String numero;
	private String email;
	private String Genero;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar dataNascimento;
	private String prodInt;
	private FaixaEtaria faixaEtaria;

	public FaixaEtaria getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(FaixaEtaria faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public String getProdInt() {
		return prodInt;
	}

	public void setProdInt(String prodInt) {
		this.prodInt = prodInt;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		int dia = dataNascimento.get(Calendar.DAY_OF_MONTH);
		int mes = dataNascimento.get(Calendar.MONTH);
		int ano = dataNascimento.get(Calendar.YEAR);
		LocalDate dataNasc = LocalDate.of(ano, mes + 1, dia);
		LocalDate dataAtual = LocalDate.now();
		Period periodo = Period.between(dataNasc, dataAtual);
		return periodo.getYears();
	}

}
