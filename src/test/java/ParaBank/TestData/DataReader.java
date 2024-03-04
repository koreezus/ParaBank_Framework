package ParaBank.TestData;

import ParaBank.TestCases.UserAccountTest;
import ParaBank.TestComponents.BaseTest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import javax.sound.sampled.AudioFormat;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class DataReader{
    public List<HashMap<String,String>> mapJsonData(String filePath) throws IOException {
        String jsonContent = Files.readString(Paths.get(filePath), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>(){
        });

    }
}
