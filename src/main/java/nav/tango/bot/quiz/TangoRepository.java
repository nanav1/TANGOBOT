package nav.tango.bot.quiz;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class TangoRepository {

    private final List<Mondai> n1Data;
    private final List<Mondai> n2Data;
    private final List<Mondai> n3Data;

    public TangoRepository() throws IOException {
        CsvLoader loader = new CsvLoader();
        n1Data = loader.load(
                Path.of("src/main/resources/data/n1.csv")
        );
        n2Data = loader.load(
                Path.of("src/main/resources/data/n2.csv")
        );
        n3Data = loader.load(
                Path.of("src/main/resources/data/n3~n5.csv")
        );
    }
    public List<Mondai> getN1Data(){
        return n1Data;
    }
    public List<Mondai> getN2Data(){
        return n2Data;
    }
    public List<Mondai> getN3Data(){
        return n3Data;
    }
}
