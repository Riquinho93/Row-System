package br.safeerp.view;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;

import br.safeerp.entitidades.ProdutoModel;

public class DeletProduto extends Panel {

	private static final long serialVersionUID = 1L;

	private ProdutoModel user = new ProdutoModel();

	public DeletProduto(String id, final ProdutoModel answer) {
		super(id);
		this.user = answer;

		Form<ProdutoModel> form = new Form<ProdutoModel>("resp");

		add(new Label("msg", "Confirma exclusão da OS?"));

		// Tamanho do Modal
		// modalWindow.setInitialHeight(200);
		// modalWindow.setInitialWidth(350);

		// Confirmando a operação
		AjaxButton yesButton = new AjaxButton("sim") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				if (target != null) {
					user.setAnswer(true);
					executarAoSalvar(target, user);

				}
			}
		};
		// Resposta de cancelar operação
		AjaxButton noButton = new AjaxButton("nao") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				if (target != null) {
					user.setAnswer(false);
					executarAoSalvar(target, user);

				}
			}
		};
		add(form);
		yesButton.setOutputMarkupId(true);
		noButton.setOutputMarkupId(true);

		form.add(yesButton);
		form.add(noButton);

	}

	// Enviando os dados para o HomePage
	public void executarAoSalvar(AjaxRequestTarget target, ProdutoModel produtoModel) {

	}
}
