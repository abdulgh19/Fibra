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
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

import fibra.mz.entity.Categoria;
import fibra.mz.entity.Cliente;
import fibra.mz.entity.TipoCliente;
import fibra.mz.service.ClienteService;
import fibra.mz.service.TipoClienteService;

public class ClienteController extends GenericForwardComposer {
	
	private Combobox cbx_tipoCliente;
	private Textbox txb_nome, txb_apelido;
	private Intbox intbx_telefone, intbx_nuit;
	private Button btn_cancelar, btn_gravar, btn_actualizar;
	private Listbox lbx_cliente;
	
	@WireVariable
	private ClienteService _clienteService;
	private TipoClienteService _tipoClienteService;
	
	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	
	@Override
	public void doBeforeComposeChildren(Component comp) throws Exception {
		super.doBeforeComposeChildren(comp);

		_clienteService = (ClienteService) SpringUtil
				.getBean("clienteService");
		_tipoClienteService = (TipoClienteService) SpringUtil.getBean("tipoClienteService");
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		preencherTipoCliente();
		listarCliente();
	}
	
	private void listarCliente() {							//Este metodo serve para preencher a tabela com uma lista de clientes
   		listaCliente = _clienteService.getAll();
   		lbx_cliente.setModel(new ListModelList<Cliente>(listaCliente));
	}
	
	private void preencherTipoCliente() {	//Este metodo preenche a ComboBox categorias
		cbx_tipoCliente.setModel(new ListModelList<TipoCliente>(_tipoClienteService.getAll()));
	}

	public void onClick$btn_cancelar(Event e) throws InterruptedException {

		limparCampos();

	}

	private void limparCampos() {
		txb_nome.setRawValue(null);
		txb_apelido.setRawValue(null);
		intbx_nuit.setRawValue(null);
		intbx_telefone.setVisible(true);
		btn_actualizar.setVisible(false);
		cbx_tipoCliente.setRawValue(null);
		listarCliente();
	}
	
	public void onClick$btn_gravar(Event e) throws InterruptedException {

		Cliente cliente = new Cliente();
		cliente.setTipoCliente((TipoCliente)cbx_tipoCliente.getSelectedItem().getValue());
		cliente.setApelido(txb_apelido.getValue());
		cliente.setNome(txb_nome.getValue());
		cliente.setNuit(intbx_nuit.getValue());
		cliente.setTelefone(intbx_telefone.getValue());
		_clienteService.create(cliente);
		showNotifications("Cliente registado com sucesso!", "info");
		limparCampos();
	}

	public void showNotifications(String message, String type) {
		Clients.showNotification(message, type, txb_nome,
				"before_center", 4000, true);
	}
	
	

	
}
