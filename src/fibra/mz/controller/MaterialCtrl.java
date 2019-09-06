package fibra.mz.controller;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.spring.SpringUtil;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

import fibra.mz.entity.Categoria;
import fibra.mz.entity.Material;
import fibra.mz.service.CategoriaService;
import fibra.mz.service.MaterialService;

public class MaterialCtrl extends GenericForwardComposer {

	private Combobox cbx_categoria;
	private Button btn_gravar, btn_actualizar, btn_cancelar;
	private Textbox txb_designacao;
	private Doublebox dbx_valorDeCompra, dbx_valorDeVenda;
	private Listbox lbx_material;

	@WireVariable
	private MaterialService _materialService;

	@WireVariable
	private CategoriaService _categoriaService;

	private Material material;
	private Categoria categoria;

	ListModelList<Categoria> _listaCategoria;
	ListModelList<Material> _listaMaterial;

	private List<Material> listaMaterial = new ArrayList<Material>();

	@Override
	public void doBeforeComposeChildren(Component comp) throws Exception {
		super.doBeforeComposeChildren(comp);

		_materialService = (MaterialService) SpringUtil
				.getBean("materialService");
		_categoriaService = (CategoriaService) SpringUtil
				.getBean("categoriaService");

	}

	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);

		preencherCategorias();
		listarMaterial();
	}

	private void listarMaterial() {
		listaMaterial = _materialService.getAll();
		_listaMaterial = new ListModelList<Material>(listaMaterial);
		lbx_material.setModel(_listaMaterial);
	}

	private void preencherCategorias() {	//Este metodo preenche a ComboBox categorias
		cbx_categoria.setModel(new ListModelList<Categoria>(_categoriaService
				.getAll()));
	}

	public void onClick$btn_cancelar(Event e) throws InterruptedException {

		limparCampos();

	}

	private void limparCampos() {
		txb_designacao.setRawValue(null);
		dbx_valorDeCompra.setRawValue(null);
		dbx_valorDeVenda.setRawValue(null);
		btn_gravar.setVisible(true);
		btn_actualizar.setVisible(false);
		cbx_categoria.setRawValue(null);
		listarMaterial();
	}

	public void onClick$btn_gravar(Event e) throws InterruptedException {

		Material _material = new Material();
		_material.setDesignacao(txb_designacao.getValue());
		_material.setCategoria((Categoria) cbx_categoria.getSelectedItem()
				.getValue());
		_material.setValorDeCompra(dbx_valorDeCompra.getValue());
		_material.setValorDevenda(dbx_valorDeVenda.getValue());
		_materialService.create(_material);
		showNotifications("Material registado com sucesso!", "info");
		limparCampos();
	}

	public void showNotifications(String message, String type) {
		Clients.showNotification(message, type, txb_designacao,
				"before_center", 4000, true);
	}
}
