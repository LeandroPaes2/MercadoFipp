package unoeste.fipp.mercadofipp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import unoeste.fipp.mercadofipp.entities.Anuncio;
import unoeste.fipp.mercadofipp.entities.Pergunta;
import unoeste.fipp.mercadofipp.repositories.AnuncioRepository;
import unoeste.fipp.mercadofipp.entities.Foto;
import java.util.List;

import static unoeste.fipp.mercadofipp.Filefoto.salvarFotoNoDisco;

@Service
public class AnuncioService {
    @Autowired
    private AnuncioRepository anuncioRepository;

    public List<Anuncio> getAll(){
        return anuncioRepository.findAll();
    }

    public Anuncio save(Anuncio anuncio, MultipartFile[] fotos) {
        Anuncio novoAnuncio = anuncioRepository.save(anuncio);
        if (novoAnuncio != null)
            addFoto(novoAnuncio.getId(), fotos);
        return novoAnuncio;
    }

    public Anuncio add(Anuncio anuncio)
    {
        Anuncio novoAnuncio=anuncioRepository.save(anuncio);
        //agora grave as fotos na tabela de fotos
        //for (Foto foto : anuncio.getFotos())
        //anuncioRepository.addFoto(foto.getFile(), novoAnuncio.getId());

        return novoAnuncio;
    }

    public boolean addPergunta(long id_anuncio, String texto){
        try{
            anuncioRepository.addPergunta(texto, id_anuncio);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean deletePergunta(long id){
        try{
            anuncioRepository.deletePergunta(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public boolean addResposta(long id_anuncio, String resposta){
        try{
            anuncioRepository.addResposta(resposta, id_anuncio);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean addFoto(long id_anuncio, MultipartFile[] fotos) {
        try {
            for (MultipartFile foto : fotos) {
                String nome = salvarFotoNoDisco(foto); // você que implementa
                anuncioRepository.addFoto(id_anuncio, nome);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public Anuncio getId(long id) {
        return anuncioRepository.findById(id).get();
    }

    public List<Anuncio> getTitulob(String titulo) {
        titulo = titulo + "%";
        return anuncioRepository.getTitulob(titulo);
    }

    public List<Anuncio> getIdUsu(long id){
        return anuncioRepository.getIdUsu(id);
    }

    public boolean delete(long id){
        try{
            anuncioRepository.deleteAllPer(id);

            anuncioRepository.delete(new Anuncio(id,"", null,"", 0, null, null));
            return true;
        }catch (Exception e){
            return false;
        }

    }

}
