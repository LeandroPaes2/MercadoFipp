package unoeste.fipp.mercadofipp.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unoeste.fipp.mercadofipp.entities.Anuncio;
import unoeste.fipp.mercadofipp.entities.Erro;
import unoeste.fipp.mercadofipp.repositories.AnuncioRepository;
import unoeste.fipp.mercadofipp.services.AnuncioService;

import java.util.List;

@RestController
@RequestMapping("apis/anuncio")
public class AnuncioRestController {
    @Autowired
    private AnuncioService anuncioService;

    @GetMapping
    public ResponseEntity<Object> getAll() {
        List<Anuncio> anuncios = anuncioService.getAll();
        if(anuncios!=null && !anuncios.isEmpty())
            return ResponseEntity.ok(anuncios);
        else
            return ResponseEntity.badRequest().body(new Erro("Anuncios não encontrados"));
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getId(@PathVariable int id) {
        Anuncio anuncios = anuncioService.getId((long)id);
        if(anuncios!=null)
            return ResponseEntity.ok(anuncios);
        else
            return ResponseEntity.badRequest().body(new Erro("Anuncios não encontrados"));
    }

    @GetMapping("get-anuncios/{titulo}")
    public ResponseEntity<Object> getTitulob(@PathVariable(name = "titulo") String titulo){
        List<Anuncio> anuncios = anuncioService.getTitulob(titulo);
        if(anuncios != null)
            return ResponseEntity.ok(anuncios);
        else
            return ResponseEntity.badRequest().body(new Erro("Anuncios não encontrados"));
    }

    @GetMapping("get-por-usuario/{id}")
    public ResponseEntity<Object> getIdUsu(@PathVariable(name = "id") Long id){
            List<Anuncio> anuncio = anuncioService.getIdUsu(id);
            if(anuncio != null)
                return ResponseEntity.ok(anuncio);
            else
                return ResponseEntity.badRequest().body(new Erro("Usuario não encontrado"));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable long id){
        if(anuncioService.delete(id))
            return ResponseEntity.noContent().build();
        return ResponseEntity.badRequest().body(new Erro("Erro ao deletar o anuncio"));
    }

    @DeleteMapping("pergunta/{id}")
    public ResponseEntity<Object> deletePergunta(@PathVariable long id){
        if(anuncioService.deletePergunta(id))
            return ResponseEntity.noContent().build();
        return ResponseEntity.badRequest().body(new Erro("Erro ao deletar o anuncio"));
    }

    @PostMapping("add-pergunta/{id}/{texto}")
    public ResponseEntity<Object> addPergunta(@PathVariable(name = "id") Long idAnuncio, @PathVariable(name = "texto") String texto){
         if(anuncioService.addPergunta(idAnuncio,texto))
             return ResponseEntity.noContent().build();
         else
             return ResponseEntity.badRequest().body(new Erro("erro ao adicionar a pergunta"));
    }


    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Anuncio anuncio){
        Anuncio novoAnuncio=anuncioService.add(anuncio);
        if(novoAnuncio!=null)
            return ResponseEntity.ok(novoAnuncio);
        else
            return ResponseEntity.badRequest().body(new Erro("Erro ao gravar o Anuncio"));
    }
    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Anuncio anuncio){
        Anuncio novoAnuncio=anuncioService.add(anuncio);
        if(novoAnuncio!=null)
            return ResponseEntity.ok(novoAnuncio);
        else
            return ResponseEntity.badRequest().body(new Erro("Erro ao alterar o Anuncio"));
    }


    //    @PostMapping("add-foto/{id}/{file}")
//    public ResponseEntity<Object> addFoto(@PathVariable(name = "id") Long idAnuncio, @PathVariable(name = "file") String file){
//        if(anuncioService.addFoto(idAnuncio,file))
//            return ResponseEntity.noContent().build();
//        else
//            return ResponseEntity.badRequest().body(new Erro("erro ao adicionar a foto"));
//    }
}
