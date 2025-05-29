package unoeste.fipp.mercadofipp.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import unoeste.fipp.mercadofipp.entities.Anuncio;
import unoeste.fipp.mercadofipp.entities.Erro;
import unoeste.fipp.mercadofipp.repositories.AnuncioRepository;
import unoeste.fipp.mercadofipp.services.AnuncioService;

import java.util.List;
import java.util.Map;

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

    @PostMapping("add-resposta/{id}/{resposta}")
    public ResponseEntity<Object> addResposta(@PathVariable(name = "id") Long idAnuncio, @PathVariable(name = "resposta") String resposta){
        if(anuncioService.addResposta(idAnuncio,resposta))
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.badRequest().body(new Erro("erro ao adicionar a resposta"));
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> addAnuncio(@RequestPart("anuncio") Anuncio anuncio, @RequestPart("fotos") MultipartFile[] fotos) {
        Anuncio novo = anuncioService.save(anuncio, fotos);
        if (novo != null)
            return ResponseEntity.ok(anuncio);
        return ResponseEntity.badRequest().body(new Erro("Erro ao cadastrar anúncio!"));
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Anuncio anuncio){
        Anuncio novoAnuncio=anuncioService.add(anuncio);
        if(novoAnuncio!=null)
            return ResponseEntity.ok(novoAnuncio);
        else
            return ResponseEntity.badRequest().body(new Erro("Erro ao alterar o Anuncio"));
    }

    @PostMapping(value = "add-foto/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> addFoto(@PathVariable(name = "id") Long idAnuncio, @RequestParam("fotos") MultipartFile[] fotos) {
        if (anuncioService.addFoto(idAnuncio, fotos))
            return ResponseEntity.ok().body(Map.of("mensagem", "Fotos adicionadas com sucesso!"));
        return ResponseEntity.badRequest().body(new Erro("Erro ao adicionar fotos!"));
    }

}
