package unoeste.fipp.mercadofipp;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class Filefoto {
    private static final String DIRETORIO_UPLOADS = "uploads";

    public static String salvarFotoNoDisco(MultipartFile arquivo) throws IOException {
        // Usa java.io.File para lidar com diretórios
        File diretorio = new File(DIRETORIO_UPLOADS);
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }

        // Gera nome único
        String extensao = getExtensao(arquivo.getOriginalFilename());
        String nomeUnico = UUID.randomUUID().toString() + extensao;

        // Caminho completo
        Path caminho = Paths.get(DIRETORIO_UPLOADS, nomeUnico);

        // Salva o arquivo
        Files.write(caminho, arquivo.getBytes());

        return nomeUnico;
    }

    private static String getExtensao(String nomeOriginal) {
        if (nomeOriginal != null && nomeOriginal.contains(".")) {
            return nomeOriginal.substring(nomeOriginal.lastIndexOf("."));
        }
        return "";
    }
}
