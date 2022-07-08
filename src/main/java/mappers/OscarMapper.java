package mappers;

import model.OscarModel;

import java.util.function.Function;

import static java.lang.Integer.parseInt;

public class OscarMapper implements Function<String, OscarModel> {


    @Override
    public OscarModel apply(String l) {

            var dadosLinha = l.split("; ");
            var index = parseInt(dadosLinha[0]);
            var ano = parseInt(dadosLinha[1]);
            var idade = parseInt(dadosLinha[2]);
            var nome = dadosLinha[3];
            var nomeDoFilme = dadosLinha[4];

            return new OscarModel(index, ano, idade, nome, nomeDoFilme);

    }
}
