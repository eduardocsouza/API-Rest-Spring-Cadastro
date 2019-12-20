package cadastroUsuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cadastroUsuario.entity.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

}
