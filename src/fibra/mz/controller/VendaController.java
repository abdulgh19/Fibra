package fibra.mz.controller;

import java.util.ArrayList;
import java.util.List;












import org.zkoss.spring.SpringUtil;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

import fibra.mz.entity.Categoria;
import fibra.mz.entity.Cliente;
import fibra.mz.entity.Material;
import fibra.mz.entity.TipoCliente;
import fibra.mz.entity.Venda;
import fibra.mz.service.CategoriaService;
import fibra.mz.service.ClienteService;
import fibra.mz.service.MaterialService;
import fibra.mz.service.VendaService;

public class VendaController extends GenericForwardComposer {
	
	private Combobox cbx_Cliente;
	private Intbox intbx_quantidade;
	private Textbox txb_nomefind;
	private Doublebox dbx_valorUnitario,dbx_subTotal;
	private Button btn_cancelar, btn_gravar, btn_actualizar, btn_pesquisar;
	private Listbox lbx_materialProcurado;
	
	@WireVariable
	private ClienteService _clienteService;
	private VendaService _vendaService;
	private MaterialService _materialService;
	private CategoriaService _categoriaService;
	
	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	private List<Material> listaMaterial = new ArrayList<Material>();
	private List<Categoria> listaCategoria = new ArrayList<Categoria>();

	
	Material material;
	
	@Override
	public void doBeforeComposeChildren(Component comp) throws Exception {
		super.doBeforeComposeChildren(comp);

		_clienteService = (ClienteService) SpringUtil
				.getBean("clienteService");
		_vendaService = (VendaService) SpringUtil.getBean("vendaService");
		_materialService = (MaterialService) SpringUtil.getBean("materialService");
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		preencherCliente();
		
	}
	
	private void listarMaterialProcurado() {			//Este metodo serve para preencher a tabela com o material buscados


	}
	
	private void preencherCliente() {	//Este metodo preenche a ComboBox categorias
		cbx_Cliente.setModel(new ListModelList<Cliente>(_clienteService.getAll()));
	}

	public void onClick$btn_cancelar(Event e) throws InterruptedException {

		limparCampos();

	}
	
 
	private void limparCampos() {
		txb_nomefind.setRawValue(null);
		btn_actualizar.setVisible(false);
		cbx_Cliente.setRawValue(null);
		//listarCliente();
	}
	
	public void onClick$btn_gravar(Event e) throws InterruptedException {

		Venda venda = new Venda();
		venda.setCliente((Cliente)cbx_Cliente.getSelectedItem().getValue());
		venda.setTotalVenda(dbx_subTotal.getValue());
		_vendaService.create(venda);
		showNotifications("Venda Efectuada com sucesso!", "info");
		limparCampos();
	}

	public void showNotifications(String message, String type) {
		Clients.showNotification(message, type, txb_nomefind,
				"before_center", 4000, true);
	}
	
	   public void onClick$btn_pesquisar(ForwardEvent e)  {
	        String nome = txb_nomefind.getValue();
	        listarMaterial(nome);
	        
		}
	   
		public void listarMaterial (String nome){
			listaMaterial = _materialService.listarMaterial(nome);
	   		lbx_materialProcurado.setModel(new ListModelList<Material>(listaMaterial));
	   	}
	
	  	public void onSelect$lbx_materialProcurado(Event e){
	  		material = lbx_materialProcurado.getSelectedItem().getValue();
	  		dbx_valorUnitario.setValue(material.getValorDevenda());

	   	}
	  	
	  	public void onChanging$dbx_valorUnitario(Event e){
	  		double valor = dbx_valorUnitario.getValue();
	  		int quantidade =  intbx_quantidade.getValue();
	  		double subtotal = calculaSubtotal(valor, quantidade);
	  		dbx_subTotal.setValue(subtotal);

	   	}

	  	
	  	public double calculaSubtotal(double valor, int quantidade) {
	  		return valor*quantidade;
	  		
	  	}
	
}
