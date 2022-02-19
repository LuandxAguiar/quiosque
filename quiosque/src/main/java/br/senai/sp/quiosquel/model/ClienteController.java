package br.senai.sp.quiosquel.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.senai.sp.quiosquel.dao.ClienteDao;

@Controller
public class ClienteController {

	@RequestMapping("cadCliente")
	private String form(Model model) {
		model.addAttribute("faixa", FaixaEtaria.values());
		return "cadcliente";
	}

	@RequestMapping("/")
	public String view() {
		System.out.println("Passou no IndexController");
		return "index";

	}

	@RequestMapping("listaCliente")
	public String listar(Model model) {
		ClienteDao dao = new ClienteDao();
		model.addAttribute("cliente", dao.listar());
		return "listacliente";
	}

	@RequestMapping("excluirCliente")
	public String excluir(long idCliente) {
		ClienteDao dao = new ClienteDao();
		dao.excluir(idCliente);
		return "redirect:listaCliente";
	}

	@RequestMapping("alterarCliente")
	public String alterar(long idCliente, Model model) {
		ClienteDao dao = new ClienteDao();
		model.addAttribute("cliente", dao.buscar(idCliente));
		return "forward:cadcliente";
	}
	
	// erro 405 request post,
		@RequestMapping(value = "salvarObj", method = RequestMethod.POST)
		public String salvar(Cliente cliente) {
			System.out.println(cliente.getNome());
			System.out.println(cliente.getEndereco());
			System.out.println(cliente.getEmail());
			System.out.println(cliente.getNumero());
			System.out.println(cliente.getDataNascimento());
			System.out.println(cliente.getGenero());
			System.out.println(cliente.getIdade());
			System.out.println(cliente.getProdInt());
			
			//mandando pro banco de dados 
			ClienteDao dao = new ClienteDao();
			dao.inserir(cliente);
			
			return "cadcliente";
		}

}
