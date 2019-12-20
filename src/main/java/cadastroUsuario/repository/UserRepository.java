package cadastroUsuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cadastroUsuario.entity.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {

}
