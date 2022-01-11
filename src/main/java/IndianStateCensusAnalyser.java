import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.Reader;
import java.io.IOException;


public class IndianStateCensusAnalyser {
    public int loadIndianCensusData(String csvFilePath) throws CensusAnalyserException{
        try{
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndianCensusCSV.class());
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndianCensusCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndianCensusCSV> indianCensusCSVIterator = csvToBean.Iterator();
            int numOfEntries = 0;
            while(indianCensusCSVIterator.hasNext()){
                numOfEntries++;
                IndianCensusCSV censusData = censusCSVIterator.next();
            }
            return numOfEntries;
            Iterable<IndianCensusCSV> csvIterable = () ->censusCSVIterator;
            int numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
            return numOfEntries;

        } catch(IOException e){

        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to India!");
        System.out.println("Today we shall deal with problems related to Indian State Census Analysis");
    }
}
