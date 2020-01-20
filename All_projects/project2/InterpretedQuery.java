/** QueryType is an enumeration specifying which type of query has been interpreted. These queries include:
 *     - create statement: "create" "table" <table name> "(" <column name> <column type>,+ ")" ";"
 *     - insert statement: "insert" "into" <table name> "values" ( "(" <literal>,+ ")" ),+ ";"
 *     - load statement: "load" <name> ";"
 *     - store statement: "store" <table name> ";"
 *     - print statement: "print" <table name> ";"
 *     - select statement: "select" <column name>,+ "from" <table name> "," <table name> <condition clause> ";"
 *     - exit statement: "exit;"
 *
 * Data members accessible/required for each type of queries. This are strictly enforced in getter methods:
 *     - "create": queryType, tableName, columnNames, columnTypes
 *     - "insert": queryType, tableName, insertValues
 *     - "load": queryType, fileName
 *     - "store": queryType, tableName
 *     - "print": queryType, tableName
 *     - "select": queryType, tableName, columnNames, conditional
 *     - "exit": queryType

 * @author Nate Larson
 * For use in the University of Minnesota's Spring 2019 semester of CSCi 1933.
 */
public class InterpretedQuery {
    private QueryType queryType;
    private String tableName;
    private String[] columnNames;
    private String[] columnTypes;
    private String[] insertValues;
    private String fileName;
    private String conditional;


    
    // Constructor for "create" queries
    public InterpretedQuery(QueryType queryType, String tableName, String[] columnNames, String[] columnTypes) {
        this.queryType = queryType;
        this.tableName = tableName;
        this.columnNames = columnNames;
        this.columnTypes = columnTypes;
    }

    // Constructor for "insert" queries
    public InterpretedQuery(QueryType queryType, String tableName, String[] insertValues) {
        this.queryType = queryType;
        this.tableName = tableName;
        this.insertValues = insertValues;
    }

    // Constructor for "load", and "print" queries
    public InterpretedQuery(QueryType queryType, String fileOrTableName) {
        this.queryType = queryType;
        if (queryType == QueryType.LOAD_STATEMENT) {
            this.fileName = fileOrTableName;
        } else {
            this.tableName = fileOrTableName;
        }
    }

    // Constructor for "exit" queries
    public InterpretedQuery(QueryType queryType) {
        this.queryType = queryType;
    }

    // Constructor for "select" queries
    public InterpretedQuery(QueryType queryType, String tableName, String[] columnNames, String conditional) {
        this.queryType = queryType;
        this.tableName = tableName;
        this.columnNames = columnNames;
        this.conditional = conditional;
    }

    public QueryType getQueryType() {
        return queryType;
    }

    public String getTableName() throws IllegalStateException {
        if (queryType == QueryType.LOAD_STATEMENT || queryType == QueryType.EXIT_STATEMENT) {
            throw new IllegalStateException("Table Name is not associated with " + queryType + " queries");
        }
        return tableName;
    }

    public String[] getColumnNames() throws IllegalStateException {
        if (queryType == QueryType.CREATE_STATEMENT || queryType == QueryType.SELECT_STATEMENT) {
            return columnNames;
        }
        throw new IllegalStateException("Column Name is not associated with " + queryType + " queries");
    }

    public String[] getColumnTypes() throws IllegalStateException {
        if (queryType == QueryType.CREATE_STATEMENT) {
            return columnTypes;
        }
        throw new IllegalStateException("Column Types is not associated with " + queryType + " queries");
    }

    public String[] getInsertValues() throws IllegalStateException {
        if (queryType == QueryType.INSERT_STATEMENT) {
            return insertValues;
        }
        throw new IllegalStateException("Insert Values is not associated with " + queryType + " queries");
    }

    public String getFileName() throws IllegalStateException {
        if (queryType == QueryType.LOAD_STATEMENT) {
            return fileName;
        }
        throw new IllegalStateException("File Name is not associated with " + queryType + " queries");
    }

    public String getConditional() throws IllegalStateException {
        if (queryType == QueryType.SELECT_STATEMENT) {
            return conditional;
        }
        throw new IllegalStateException("Conditional is not associated with " + queryType + " queries");
    }
}
