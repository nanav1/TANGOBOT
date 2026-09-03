package nav.tango.bot.quiz;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.input.BOMInputStream;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvLoader {

    public List<Mondai> load(Path csvPath) throws IOException{
        List<Mondai> tangoData = new ArrayList<>();

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .setIgnoreEmptyLines(true)
                .setTrim(true)
                .get();

        try(
        Reader reader = new InputStreamReader(
                BOMInputStream.builder()
                        .setPath(csvPath)
                        .setInclude(false)
                        .get(),
                StandardCharsets.UTF_8
            );
                CSVParser parser = csvFormat.parse(reader)
        )
        {
            for (CSVRecord csvRecord : parser){
              Mondai tango = new Mondai(
                      csvRecord.get("expression"),
                      csvRecord.get("reading"),
                      csvRecord.get("meaning")
              );

              tangoData.add(tango);
            }
        }

        return tangoData;
    }
}
