package cadastroUsuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import cadastroUsuario.entity.Telefone;
import cadastroUsuario.entity.Usuario;
import cadastroUsuario.repository.TelefoneRepository;
import cadastroUsuario.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	//injeção de dependência com a interface Repository para acessar o banco.
	@Autowired
	private TelefoneRepository telRepository;
	
	//Lista todos os usuários do banco. 
	public Usuario addUser(Usuario user) {
		return repository.save(user);
	}
	
	//Busca um objeto do tipo usuário com um ID específico e retorna para uma HTML de nome "telefone".
	public ModelAndView addTelefone(long id) {
		ModelAndView mv = new ModelAndView("telefone");
		Optional<Usuario> user = repository.findById(id);
		mv.addObject("userId", user.get());
		return mv;
	}
	
	//Recebe um objeto do tipo telefone com um ID específico, salva no banco e retorna para uma HTML de nome "telefone".
	public ModelAndView addTelUser(Telefone tel, long id) {
		ModelAndView mv = new ModelAndView("telefone");
		Usuario user = repository.findById(id).get();
		tel.setUsuario(user);
		telRepository.save(tel);
		mv.addObject("userId", user);
		return mv;
	}	
	
	
	
	
	
	
	//Lista um objeto do tipo usuário e retorna para a uma HTML de nome "lista".
	public ModelAndView findAll(){
		ModelAndView mv = new ModelAndView("lista");
		List<Usuario> list = repository.findAll();
		mv.addObject("usuario", list);
		return mv;
	}
	
	//Busca um objeto do tipo usuário com um ID específico e retorna para a uma HTML de nome "editar-cadastro".
	public ModelAndView editar(long id) {
		ModelAndView mv = new ModelAndView("editar-cadastro");
		Optional<Usuario> user = repository.findById(id);
		mv.addObject("usuario", user.get());		
		return mv;
	}
	
	//Recebe um objeto do tipo usuario e um ID, subistitui o nome e email, salva e retorna para a uma HTML de nome "cadastro".
	public ModelAndView salvarEdit(long id, Usuario obj) {
		ModelAndView mv = new ModelAndView("cadastro");
		Usuario entity = repository.findById(id).get();
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		repository.save(entity);
		mv.addObject("usuario", new Usuario());
		return mv;
	}
			
	//Deleta um objeto do tipo usuário com um ID específico e retorna para a uma HTML de nome "lista".
	public ModelAndView excluir(long id) {
		ModelAndView mv = new ModelAndView("lista");
		telRepository.deleteById(id);		
		repository.deleteById(id);
		List<Usuario> list = repository.findAll();
		
		mv.addObject("usuario", list);
		return mv;
	}
	
	

}
