import java.io.*;
import java.util.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.csv.*;
public class csv {
    public static void main(String args[]) throws Exception {
        File input = new File("/home/ajay/IdeaProjects/csvjson/src/input.csv");
        try {
            CsvSchema csv = CsvSchema.emptySchema().withHeader(); // Schema for specifying format
            CsvMapper csvMapper = new CsvMapper(); //Mapper for csv
            MappingIterator<Map<?, ?>> mappingIterator =  csvMapper.reader().forType(Map.class).with(csv).readValues(input); //Serializing csv
            List<Map<?, ?>> list = mappingIterator.readAll();
            System.out.println(list);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
