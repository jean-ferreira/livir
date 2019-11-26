package br.com.promove.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.com.promove.entidade.Emprestimo;

public class DataGeneration {
	/**
	 * Método que vai criar a tabela Especificar a entidade em
	 * conf.addAnnotatedClass Baseado nos atributos da classe, vai criar os
	 * campos da tabela
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		AnnotationConfiguration an = new AnnotationConfiguration();
		an.addAnnotatedClass(Emprestimo.class);
		
		an.configure();

		new SchemaExport(an).create(true, true);

	}
}