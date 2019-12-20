package cadastroUsuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import cadastroUsuario.entity.Telefone;
import cadastroUsuario.repository.TelefoneRepository;
import cadastroUsuario.repository.UserRepository;

@Service
public class TelefoneService {
	
	@Autowired
	private TelefoneRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
				
		public Telefone addTel(Telefone tel) {
			return repository.save(tel);
		}
		
		public ModelAndView findAll(){
			ModelAndView mv = new ModelAndView("listaTelefone");
			List<Telefone> list = repository.findAll();
			mv.addObject("telefone", list);
			return mv;
		}
		
		public ModelAndView editar(long id) {
			ModelAndView mv = new ModelAndView("telefone");
			Optional<Telefone> user = repository.findById(id);
			mv.addObject("usuario", user.get());
			return mv;
		}
		
		public ModelAndView excluir(long id) {
			ModelAndView mv = new ModelAndView("listaTelefone");
			repository.deleteById(id);
			List<Telefone> list = repository.findAll();
			
			mv.addObject("usuario", list);
			return mv;
		}


}
