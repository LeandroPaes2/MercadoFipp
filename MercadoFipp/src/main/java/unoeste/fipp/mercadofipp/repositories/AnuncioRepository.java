package unoeste.fipp.mercadofipp.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import unoeste.fipp.mercadofipp.entities.Anuncio;
import unoeste.fipp.mercadofipp.entities.Pergunta;
import unoeste.fipp.mercadofipp.entities.Usuario;

import java.util.List;


public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO pergunta_anuncio (per_text, anu_id) VALUES (:texto, :id_anuncio)", nativeQuery = true)
    public void addPergunta(@Param("texto") String texto, @Param("id_anuncio") Long id_anuncio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO pergunta_anuncio (per_resp, anu_id) VALUES (:resposta, :id_anuncio)", nativeQuery = true)
    public void addResposta(@Param("resposta") String resposta, @Param("id_anuncio") Long id_anuncio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO foto_anuncio (fot_file, anu_id) VALUES (:file, :id_anuncio)", nativeQuery = true)
    public void addFoto(@Param("file") String file, @Param("id_anuncio") Long id_anuncio);

    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM anuncio WHERE anu_title ILIKE :title", nativeQuery = true)
    public List<Anuncio> getTitulob(@Param("title") String title);

    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM anuncio WHERE usr_id = :id", nativeQuery = true)
    public List<Anuncio> getIdUsu(@Param("id") Long id );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM pergunta_anuncio WHERE per_id = :id", nativeQuery = true)
    public void deletePergunta(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM pergunta_anuncio WHERE anu_id = :id", nativeQuery = true)
    public void deleteAllPer(@Param("id") Long id);
}
