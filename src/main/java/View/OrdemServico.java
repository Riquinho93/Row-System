package View;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.WindowClosedCallback;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.LoadableDetachableModel;

import Model.ColecaoModel;
import Model.OrdemModel;

public class OrdemServico extends HomePage {

	private static final long serialVersionUID = 1L;

	private ModalWindow modalWindow;
	private ArrayList<OrdemModel> ordemModels = new ArrayList<OrdemModel>();

	private ListView<OrdemModel> listView = null;
	Form<?> form = new Form<Object>("form");

	// Criando um container
	private WebMarkupContainer listContainer = null;
	private LoadableDetachableModel<List<OrdemModel>> loadList;

	public OrdemServico() {
		add(new Label("msgm", "LISTA OS"));
		// Metodo do container
		add(divConteiner());

		// Modal Windows
		modalWindow = new ModalWindow("modalWindow");
		new OSPanel(modalWindow.getContentId());

		add(modalWindow);

		// modalWindow.add(samplePanel);

		// Criando janela do Perfil
		add(new AjaxLink<String>("viewLink") {
			private static final long serialVersionUID = -182677973237618503L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				OSPanel osPanel = new OSPanel(modalWindow.getContentId()) {

					private static final long serialVersionUID = 1L;

					public void executarAoSalvar(AjaxRequestTarget target, OrdemModel ordemModel) {

						ordemModels.add(ordemModel);
						form.clearInput();
						form.modelChanged();
						// form.setModelObject(userModel);

						target.add(listContainer);
						// modalWindow.clearOriginalDestination();
						modalWindow.close(target);
					};
				};

				modalWindow.setContent(osPanel);
				target.add(listContainer);
				modalWindow.show(target);

			}

		});

		// Fachando a janela
		modalWindow.setWindowClosedCallback(new WindowClosedCallback() {
			private static final long serialVersionUID = -162677973237618503L;

			@Override
			public void onClose(AjaxRequestTarget target) {
				modalWindow.close(target);
			}
		});

	}

	// ListView
	private WebMarkupContainer divConteiner() {
		listContainer = new WebMarkupContainer("theContainer");
		listContainer.setOutputMarkupId(true);
		loadList = new LoadableDetachableModel<List<OrdemModel>>() {

			private static final long serialVersionUID = 1L;

			protected List<OrdemModel> load() {
				return ordemModels;
			}
		};
		// Criando a lista View
		listView = new ListView<OrdemModel>("listview", loadList) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<OrdemModel> item) {
				OrdemModel user = item.getModelObject();
				// item.add(new Label("ID", user.getId()));
				item.add(new Label("modelo", user.getModelo()));
				item.add(editando(user).setOutputMarkupId(true));
				item.add(removendo(item.getIndex()));
			}

		};

		listView.setOutputMarkupId(true);

		// Aparecer no container
		listContainer.add(listView);

		return listContainer;
	}

	// // Removendo modelo com ajaxLink
	protected Component removendo(final int index) {
		AjaxLink<OrdemModel> button1 = new AjaxLink<OrdemModel>("del") {
			OrdemModel answer = new OrdemModel();

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				DeletOS deleOS = new DeletOS(modalWindow.getContentId(), answer) {

					private static final long serialVersionUID = 1L;

					public void executarAoSalvar(AjaxRequestTarget target, OrdemModel ordemModel) {
						if (ordemModel.isAnswer() == true) {
							ordemModels.remove(index);
							target.add(listContainer);
						}
						System.out.println("TTT2");
						modalWindow.close(target);
					};
				};
				deleOS.setOutputMarkupId(true);
				modalWindow.setContent(deleOS);
				modalWindow.show(target);
			}
		};
		button1.setOutputMarkupId(true);
		form.add(button1);
		return button1;
	}

	// Editando os campos
	AjaxLink<OrdemModel> editando(final OrdemModel user) {
		AjaxLink<OrdemModel> button1 = new AjaxLink<OrdemModel>("alt") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				OSPanel osPanel = new OSPanel(modalWindow.getContentId(), user) {

					private static final long serialVersionUID = 1L;

					public void executarAoSalvar(AjaxRequestTarget target, OrdemModel ordemModel) {

						target.add(listContainer);
						modalWindow.close(target);
					};
				};

				osPanel.setOutputMarkupId(true);
				modalWindow.setContent(osPanel);
				modalWindow.show(target);

			}
		};

		button1.setOutputMarkupId(true);
		form.add(button1);
		return button1;
	}

}
