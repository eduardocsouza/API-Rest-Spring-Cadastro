package cadastroUsuario.resoucer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cadastroUsuario.entity.Telefone;
import cadastroUsuario.entity.Usuario;
import cadastroUsuario.service.UserService;

@Controller
public class UserResource {

	@Autowired
	private UserService services;
	
	
	//retorna para a tela de cadastro.
	@GetMapping(value ="/cadastroUsuario")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("cadastro");
		mv.addObject("usuario", new Usuario());
		return mv;
	}
	
	//Salva um novo usuário e retorna para a URI listaUsuarios.
	@PostMapping("/cadastroUsuario")
	public String form(Usuario user) {
		services.addUser(user);
		return "redirect:/listaUsuarios";
	}
	
	//Busca no banco um usuário com o ID específico. 
	@GetMapping("/adicionarTelefone/{id}")
	public ModelAndView addTelefone(@PathVariable("id") long id) {
		return services.addTelefone(id);
	}
	
	//Adiciona um tele fone a um usuário de ID específico. 
	@PostMapping("/cadastroUsuarioTel/{id}")
	public ModelAndView addTelUser(Telefone tel ,@PathVariable("id") long id) {
		return services.addTelUser(tel, id);
	}	
	
	
	
	
	//Lista todos os usuários.
	@RequestMapping("/listaUsuarios")
	public ModelAndView findAll(){
		return services.findAll();
		
	}
	
	//Busca um usuário de ID específico para editar.
	@GetMapping("/editarUsuario/{id}")
	public ModelAndView editeUser(@PathVariable("id") long id) {
		return services.editar(id);
	}
	
	//Salva um usuário editado. 
	@PostMapping("/salvarEdit/{id}")
	public ModelAndView salvarEdit(@PathVariable long id, Usuario obj) {
		return services.salvarEdit(id, obj);
	}
	
	//Deleta usuário. 
	@GetMapping("/excluirUsuario/{id}")
	public ModelAndView excluirUser(@PathVariable("id") long id) {
		return services.excluir(id);
	}
			
	
}

