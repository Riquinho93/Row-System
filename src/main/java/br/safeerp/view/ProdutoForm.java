package br.safeerp.view;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.WindowClosedCallback;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.request.handler.resource.ResourceStreamRequestHandler;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.ContentDisposition;
import org.apache.wicket.util.resource.AbstractResourceStreamWriter;

import br.safeeerp.excel.RelatorioExcel;
import br.safeerp.entitidades.ProdutoModel;
import br.safeerp.relatorios.Relatorio;
import net.sf.jasperreports.engine.JRException;

public class ProdutoForm extends HomePage {

	private static final long serialVersionUID = 1L;

	private ModalWindow modalWindow;
	private List<ProdutoModel> produtoModels = new ArrayList<ProdutoModel>();
	private ListView<ProdutoModel> listView = null;
	Form<?> form = new Form<Object>("form");

	// Criando um container
	private WebMarkupContainer listContainer = null;
	private LoadableDetachableModel<List<ProdutoModel>> loadList;

	public ProdutoForm(PageParameters parameters) {

		add(new Label("tnome", parameters.get("nome")));
		add(new Label("dtEntrada", parameters.get("dtEntrada")));

		add(new Label("msgm", "PRODUTOS")).setOutputMarkupId(true);
		// Metodo do container
		add(divConteiner());

		// Modal Windows
		modalWindow = new ModalWindow("modalWindow");
		new ProdutoPanel(modalWindow.getContentId());

		// Tamanho do Modal
		modalWindow.setInitialHeight(600);
		modalWindow.setInitialWidth(1000);
		modalWindow.setOutputMarkupId(true);
		add(modalWindow);

		// modalWindow.add(samplePanel);

		// Criando janela do Perfil
		add(new AjaxLink<String>("viewLink") {
			private static final long serialVersionUID = -182677973237618503L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				ProdutoPanel osPanel = new ProdutoPanel(modalWindow.getContentId()) {

					private static final long serialVersionUID = 1L;

					public void executarAoSalvar(AjaxRequestTarget target, ProdutoModel produtoModel) {

						produtoModels.add(produtoModel);
						form.clearInput();
						form.modelChanged();
						// form.setModelObject(userModel);
						form.setOutputMarkupId(true);
						target.add(listContainer);
						// modalWindow.clearOriginalDestination();
						modalWindow.close(target);
					};
				};

				modalWindow.setContent(osPanel).setOutputMarkupId(true);
				target.add(listContainer);
				modalWindow.show(target);

			}

		});

	}

	// ListView
	private WebMarkupContainer divConteiner() {
		listContainer = new WebMarkupContainer("theContainer");
		listContainer.setOutputMarkupId(true);
		loadList = new LoadableDetachableModel<List<ProdutoModel>>() {

			private static final long serialVersionUID = 1L;

			protected List<ProdutoModel> load() {
				return produtoModels;
			}
		};
		// Criando a lista View
		listView = new ListView<ProdutoModel>("listview", loadList) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<ProdutoModel> item) {
				ProdutoModel user = item.getModelObject();
				// item.add(new Label("ID", user.getId()));
				item.add(new Label("modelo", user.getModelo()).setOutputMarkupId(true));
				item.add(new Label("largura", user.getLargura()));
				item.add(new Label("tipoEnfesto", user.getTipoEnfesto()));
				item.add(new Label("dtEntrada", user.getDtEntrada()));
				item.add(new Label("dtSaida", user.getDtSaida()));
				item.add(new Label("status", user.getStatus()));
				item.add(editando(user).setOutputMarkupId(true));
				item.add(removendo(item.getIndex()).setOutputMarkupId(true));
				item.add(Devolucao(item.getIndex(), user).setOutputMarkupId(true));
				item.add(gerarRelatorio(user));
				item.add(gerarExecel(user).setOutputMarkupId(true));
			}

		};

		listView.setOutputMarkupId(true);

		// Aparecer no container
		listContainer.add(listView).setOutputMarkupId(true);

		return listContainer;
	}

	// // Removendo modelo com ajaxLink
	protected Component removendo(final int index) {

		// Tamanho do Modal
		// modalWindow2.setInitialHeight(300);
		// modalWindow2.setInitialWidth(300);
		// add(modalWindow2).setOutputMarkupId(true);

		AjaxLink<ProdutoModel> button1 = new AjaxLink<ProdutoModel>("del") {
			ProdutoModel answer = new ProdutoModel();
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {

				DeletProduto deleOS = new DeletProduto(modalWindow.getContentId(), answer) {

					private static final long serialVersionUID = 1L;

					public void executarAoSalvar(AjaxRequestTarget target, ProdutoModel produtoModel) {
						if (produtoModel.isAnswer() == true) {
							produtoModels.remove(index);
							target.add(listContainer);
						}
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
	AjaxLink<ProdutoModel> editando(final ProdutoModel user) {
		AjaxLink<ProdutoModel> button1 = new AjaxLink<ProdutoModel>("alt") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				ProdutoPanel osPanel = new ProdutoPanel(modalWindow.getContentId(), user) {

					private static final long serialVersionUID = 1L;

					public void executarAoSalvar(AjaxRequestTarget target, ProdutoModel produtoModel) {

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

	// Enviando para Pagina DevolucaoForm
	AjaxLink<DevolucaoForm> Devolucao(final int index, final ProdutoModel user) {
		AjaxLink<DevolucaoForm> button1 = new AjaxLink<DevolucaoForm>("devolucao") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				PageParameters parameters = new PageParameters();
				parameters.add("modelo", user.getModelo());
				parameters.add("largura", user.getLargura());
				parameters.add("tipoEnfesto", user.getTipoEnfesto());
				parameters.add("dtEntrada", user.getDtEntrada());
				parameters.add("dtSaida", user.getDtSaida());
				parameters.add("status", user.getStatus());
				setResponsePage(DevolucaoForm.class, parameters);

			}

		};

		button1.setOutputMarkupId(true);
		form.add(button1);
		return button1;
	}

	// Gerar relatorio de Produto
	public Link<?> gerarRelatorio(ProdutoModel user) {
		final Relatorio r = new Relatorio();
		final HashMap<String, Object> produto = new HashMap<String, Object>();
		// Chave para o Jasper
		produto.put("user", user);
		Link<?> button = new Link<Object>("relatorio") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				try {
					final byte[] bytes;
					bytes = r.gerarRelatorio(produto);
					if (bytes != null) {
						AbstractResourceStreamWriter Stream = new AbstractResourceStreamWriter() {

							private static final long serialVersionUID = 1L;

							@Override
							public void write(OutputStream output) throws IOException {
								output.write(bytes);
								output.close();
							}

						};

						ResourceStreamRequestHandler handler = new ResourceStreamRequestHandler(Stream);
						handler.setContentDisposition(ContentDisposition.ATTACHMENT);
						// nome do pdf
						handler.setFileName("Produtos.pdf");
						getRequestCycle().scheduleRequestHandlerAfterCurrent(handler);
					}
				} catch (JRException e) {
					e.printStackTrace();
				}

			}
		};
		button.setOutputMarkupId(true);
		return button;

	}

	// Gerar file do excel
	public Link<?> gerarExecel(final ProdutoModel user) {

		final RelatorioExcel relatorio = new RelatorioExcel();

		Link<ByteArrayOutputStream> button = new Link<ByteArrayOutputStream>("excel") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {

				final ByteArrayOutputStream bytes = relatorio.gerarRelatorio(user);
				if (bytes != null) {
					AbstractResourceStreamWriter Stream = new AbstractResourceStreamWriter() {

						private static final long serialVersionUID = 1L;

						@Override
						public void write(OutputStream output) throws IOException {
							output.write(bytes.toByteArray());
							output.close();
						}

					};

					ResourceStreamRequestHandler handler = new ResourceStreamRequestHandler(Stream);
					handler.setContentDisposition(ContentDisposition.ATTACHMENT);
					// nome do excel
					handler.setFileName("Produtos.xlsx");
					getRequestCycle().scheduleRequestHandlerAfterCurrent(handler);
				}

			}
		};
		button.setOutputMarkupId(true);
		add(button);
		return button;
	}

}
