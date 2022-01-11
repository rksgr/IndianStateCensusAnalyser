import exception.CensusAnalyserException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import service.CensusAnalyser;

public class CensusAnalyserTest {
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources";

    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords(){
        try{
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndianCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assertions.assertEquals(2,numOfRecords);
        }catch(CensusAnalyserException e){

        }
    }
}
