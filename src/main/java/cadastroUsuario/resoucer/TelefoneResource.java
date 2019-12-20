package cadastroUsuario.resoucer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import cadastroUsuario.service.TelefoneService;

@Controller
public class TelefoneResource {

	@Autowired
	private TelefoneService services;
	
	@GetMapping("/listaTelefone")
	public ModelAndView findAll(){
		return services.findAll();
		
	}
	
	@GetMapping("/editarTelefone/{id}")
	public ModelAndView editeUser(@PathVariable("id") long id) {
		return services.editar(id);
	}
	
	@GetMapping("/excluirTelefone/{id}")
	public ModelAndView excluirUser(@PathVariable("id") long id) {
		return services.excluir(id);
	}
	
}
