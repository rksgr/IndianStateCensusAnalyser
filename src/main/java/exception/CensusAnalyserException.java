package exception;

public class CensusAnalyserException extends Exception{
    enum Exception_Type{
        CENSUS_FILE_PROBLEM,
        UNABLE_TO_PARSE;
    }
    Exception_Type type ;

    public CensusAnalyserException(String message, Exception_Type type){
        super(message);
        this.type = type;
    }

    public CensusAnalyserException(String message, Exception_Type type, Throwable cause){
        super(message,cause);
        this.type = type;
    }

}
