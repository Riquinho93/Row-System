package view;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class DevolucaoForm extends HomePage{

	private static final long serialVersionUID = 1L;
	
	public DevolucaoForm(PageParameters parameters){
		
		add(new Label("modelo", parameters.get("modelo")));
		add(new Label("largura", parameters.get("largura")));
		add(new Label("tipoEnfesto", parameters.get("tipoEnfesto")));
		add(new Label("dtEntrada", parameters.get("dtEntrada")));
		add(new Label("dtSaida", parameters.get("dtSaida")));
		add(new Label("status", parameters.get("status")));
		
		add(new Label("dev", "ORDEM DE SERVIÇOS DEVOLUTIVAS")).setOutputMarkupId(true);
		
	}
}
