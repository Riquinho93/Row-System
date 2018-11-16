package View;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.WindowClosedCallback;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;

import Model.ColecaoModel;
import Model.UserModel;

public class OrdemServico extends HomePage{
	
	private static final long serialVersionUID = 1L;
	
	private ModalWindow modalWindow;
	private ArrayList<ColecaoModel> colecaoModels = new ArrayList<ColecaoModel>();

	private ListView<ColecaoModel> listView = null;
	Form<?> form = new Form<Object>("form");

	// Criando um container
	private WebMarkupContainer listContainer = null;
	private LoadableDetachableModel<List<ColecaoModel>> loadList;
	
	public OrdemServico(){
		
		
		// Metodo do container
		add(divConteiner());
		

		// Modal Windows
		modalWindow = new ModalWindow("modalWindow");
		new SamplePanel(modalWindow.getContentId());

		add(modalWindow);

		// modalWindow.add(samplePanel);

		// Criando janela do Perfil
		add(new AjaxLink<String>("viewLink") {
			private static final long serialVersionUID = -182677973237618503L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				SamplePanel samplePanel3 = new SamplePanel(modalWindow.getContentId()) {

					private static final long serialVersionUID = 1L;

					public void executarAoSalvar(AjaxRequestTarget target, ColecaoModel colecaoModel) {

						colecaoModels.add(colecaoModel);
						form.clearInput();
						form.modelChanged();
						// form.setModelObject(userModel);

						target.add(listContainer);
						// modalWindow.clearOriginalDestination();
						modalWindow.close(target);
					};
				};

				modalWindow.setContent(samplePanel3);
				target.add(listContainer);
				modalWindow.show(target);

			}

		});

		// Colocando nome da janela
		modalWindow.setTitle("Second Window");

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
			loadList = new LoadableDetachableModel<List<ColecaoModel>>() {

				private static final long serialVersionUID = 1L;

				protected List<ColecaoModel> load() {
					return colecaoModels;
				}
			};
			// Criando a lista View
			listView = new ListView<ColecaoModel>("listview", loadList) {

				private static final long serialVersionUID = 1L;

				@Override
				protected void populateItem(ListItem<ColecaoModel> item) {
					ColecaoModel user = item.getModelObject();
					// item.add(new Label("ID", user.getId()));
					item.add(new Label("nome", user.getNome()));
					item.add(editando(user).setOutputMarkupId(true));
				//	item.add(removendo(item.getIndex()));

				}

			};

			listView.setOutputMarkupId(true);
			// Encapsular a ListView aqui WebMarkupContainer

			// listContainer.add(new
			// AjaxSelfUpdatingTimerBehavior(Duration.seconds(3)));
			// Aparecer no container
			listContainer.add(listView);

			return listContainer;
		}

//		// Removendo modelo com ajaxLink
//		protected Component removendo(final int index) {
//			AjaxLink<ColecaoModel> button1 = new AjaxLink<ColecaoModel>("del") {
//				ColecaoModel answer = new ColecaoModel();
//
//				private static final long serialVersionUID = 1L;
//
//				@Override
//				public void onClick(AjaxRequestTarget target) {
//					MyPanel myPanel = new MyPanel(modalWindow.getContentId(), answer) {
//					
//						private static final long serialVersionUID = 1L;
//
//						public void executarAoSalvar(AjaxRequestTarget target, colecaoModel ColecaoModel) {
//							if (colecaoModel.isAnswer() == true) {
//								colecaoModels.remove(index);
//								 target.add(listContainer);
//							}
//
//							modalWindow.close(target);
//							System.out.println("SSSSSS");
//						};
//					};
//					myPanel.setOutputMarkupId(true);
//					modalWindow.setContent(myPanel);
//					modalWindow.show(target);
//				}
//			};
//			button1.setOutputMarkupId(true);
//			form.add(button1);
//			return button1;
//		}

		// Editando os campos
		AjaxLink<ColecaoModel> editando(final ColecaoModel user) {
			AjaxLink<ColecaoModel> button1 = new AjaxLink<ColecaoModel>("alt") {

				private static final long serialVersionUID = 1L;

				@Override
				public void onClick(AjaxRequestTarget target) {
					SamplePanel samplePanel3 = new SamplePanel(modalWindow.getContentId(), user) {

						private static final long serialVersionUID = 1L;

						public void executarAoSalvar(AjaxRequestTarget target, ColecaoModel colecaoModel) {

							// while (list.hasNext()) {
							// list.next();
							// if (userModel.getId().equals(user.getId())) {
							// list.remove();
							// System.out.println("DDD" + userModel.getId());
							// break;
							// }
							// }

							// userModels.remove(user);
							// userModels.add(userModel);

							target.add(listContainer);
							modalWindow.close(target);
							System.out.println("CCCCCCCCC");
						};
					};

					samplePanel3.setOutputMarkupId(true);
					modalWindow.setContent(samplePanel3);
					modalWindow.show(target);

				}
			};

			button1.setOutputMarkupId(true);
			form.add(button1);
			return button1;
		}

		
}
