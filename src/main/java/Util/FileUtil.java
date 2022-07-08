package Util;

import model.OscarModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class FileUtil<T> {

    private final String fileName;

    public FileUtil(String fileName) {
        this.fileName = fileName;
    }

    public List<T> readFile(Function<String, T> mapper) throws IOException {

        var file = this.getClass().getClassLoader().getResourceAsStream(this.fileName);

        if  ( file == null) {throw new IllegalArgumentException("Arquivo não encontrado");}

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(file))){

           return reader.lines()
                    .skip(1)
                    .map(mapper)
                    .collect(Collectors.toList());
        }

//        Scanner sc = new Scanner(file);
//        while (sc.hasNext()){
//            var linha = sc.next();
//            System.out.println(linha);
//
//        }

    }
}
