package br.safeerp.relatorios;

import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

public class Relatorio implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public byte[] gerarRelatorio(HashMap<String, Object> produto) throws JRException{
		
		InputStream arq = Relatorio.class.getResourceAsStream("/Relatorio/ProdutosRelatorio.jasper");
//		
//		JasperReport report = JasperCompileManager.compileReport(arq);
//		
//		JasperPrint print = JasperFillManager.fillReport(report, produto, new JREmptyDataSource());
		
//		JasperViewer.viewReport(print, false);
		return JasperRunManager.runReportToPdf(arq, produto, new JREmptyDataSource());
		
	}
}
