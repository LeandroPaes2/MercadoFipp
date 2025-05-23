package unoeste.fipp.mercadofipp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unoeste.fipp.mercadofipp.entities.Anuncio;
import unoeste.fipp.mercadofipp.entities.Pergunta;
import unoeste.fipp.mercadofipp.repositories.AnuncioRepository;
import unoeste.fipp.mercadofipp.entities.Foto;
import java.util.List;

@Service
public class AnuncioService {
    @Autowired
    private AnuncioRepository anuncioRepository;

    public List<Anuncio> getAll(){
        return anuncioRepository.findAll();
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

    public boolean addFoto(long id_anuncio, String file){
        try {
            anuncioRepository.addFoto(file, id_anuncio);
            return true;
        } catch (Exception e){
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
