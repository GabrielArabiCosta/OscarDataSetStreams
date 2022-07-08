package service;

import model.OscarModel;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OscarSevice {

    private final List<OscarModel> oscarModel;

    public OscarSevice(List<OscarModel> oscarModel) {
        this.oscarModel = oscarModel;
    }

    public void atorMaisJovemPremiado(){
        oscarModel.stream()
                .collect(Collectors.groupingBy(OscarModel::getIdade))
                .entrySet().stream()
                .min(Map.Entry.comparingByKey()).get().getValue()
                .forEach(a -> System.out.printf("O ator mais jovem premiado pelo Oscar foi %s com %d ano de idade", a.getNome(), a.getIdade()));
    }

    public void atorMaisPremiado(){
        var maisPremiado = oscarModel.stream()
                .collect(Collectors.groupingBy(OscarModel::getNome, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());

        maisPremiado.ifPresent( a-> System.out.printf("O ator com mais premiações no Oscar foi %s com %d premios", a.getKey(), a.getValue() ));
    }


    public void atorMaisPremiadoentre18e24(){
        var maisPremiado = oscarModel.stream()
                .filter(a -> a.getIdade() < 24 && a.getIdade()>=18)
                .collect(Collectors.groupingBy(OscarModel::getNome, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());

        maisPremiado.ifPresent( a-> System.out.printf("O ator com idade entre 18 e 24 com mais premiações no Oscar foi %s, com %d premios", a.getKey(), a.getValue() ));



    }
}
