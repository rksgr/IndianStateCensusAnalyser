package service;

import exception.CensusAnalyserException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.Reader;
import java.io.IOException;
import java.util.stream.StreamSupport;



public class CensusAnalyser {
    public int loadIndianCensusData(String csvFilePath) throws CensusAnalyserException{
        try{
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndianCensusCSV.class());
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);

            CsvToBean<IndianCensusCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndianCensusCSV> indianCensusCSVIterator = csvToBean.Iterator();

            Iterable<IndianCensusCSV> csvIterable = () ->indianCensusCSVIterator;
            int numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
            return numOfEntries;

        } catch(IOException e){
            throw new CensusAnalyserException (e.getMessage(),
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch(IllegalStateException e){
            throw new CensusAnalyserException (e.getMessage(),
                    CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to India!");
        System.out.println("Today we shall deal with problems related to Indian State Census Analysis");
    }
}
