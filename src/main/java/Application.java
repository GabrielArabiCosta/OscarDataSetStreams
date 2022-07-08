import Util.FileUtil;
import mappers.OscarMapper;
import model.OscarModel;
import service.OscarSevice;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) throws IOException {

        var fileUtilMale = new FileUtil<OscarModel>("oscar_age_male.csv");
        var fileUtilFemale = new FileUtil<OscarModel>("oscar_age_female.csv");

        var dadosOscarMale = fileUtilMale.readFile(new OscarMapper());
        var dadosOscarFemale = fileUtilFemale.readFile(new OscarMapper());

        var dadorOscarGeneral = Stream.concat(dadosOscarMale.stream(), dadosOscarFemale.stream());

        var oscarService = new OscarSevice(dadorOscarGeneral.collect(Collectors.toList()));

//        oscarService.atorMaisJovemPremiado();
        oscarService.atorMaisPremiado();
        oscarService.atorMaisPremiadoentre18e24();
    }

}
