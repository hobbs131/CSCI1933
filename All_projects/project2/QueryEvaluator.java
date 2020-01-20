import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * QueryEvaluator is designed to house logic to parse queries for the simple DBBMS project. It conforms the the
 * following semi-formal schema:
 *
 * <program> ::= <statement>*
 * <statement> ::=
 *      <create> <statement>
 *     | <exit> <statement>
 *     | <insert> <statement>
 *     | <load> <statement>
 *     | <print> <statement>
 *     | <select> <statement>
 *     | <store> <statement>
 *
 * <create statement> :: "create" "table" <name> <table definition> ";"
 * <table definition> ::=
 *       "(" <column name> <column type>,+ ")"
 *     | "as" <select clause>
 * <print statement> ::= "print" <table name> ";"
 *
 * <insert statement> ::=
 *       "insert" "into" <table name> "values" ( "(" <literal>,+ ")" ),+ ";"
 * <load statement> ::= "load" <name> ";"
 * <store statement> ::= "store" <table name> ";"
 * <exit statement> ::= "quit" ";" | "exit" ";"
 *
 * <select statement> ::= <select clause> ";"
 * <select clause> ::= "select" <column name>+, "from" <tables> <condition clause>
 * <condition clause> ::=
 *       "where" <condition> ("and" <condition>)*
 *     | <empty>
 * <tables> ::= <table name> | <table name> "," <table name>
 * <condition> ::=
 *       <column name> <relation> <column name>
 *     | <column name> <relation> <literal>
 *
 * <relation> ::= "<" | ">" | "=" | "!=" | "<=" | ">="
 * <table name> ::= <name>
 * <column name> ::= <name>
 *
 * This schema is based off and slighted edited from the supplied schema definition in UC Berkley's CS61B Fall 2017's
 * first project "A Simple Database System".
 *     course webpage: https://inst.eecs.berkeley.edu/~cs61b/fa17/
 *     instructor: Paul Hilfinger
 *     instructor webpage: https://www2.eecs.berkeley.edu/Faculty/Homepages/hilfinger.html
 *
 * @author Nate Larson
 * For use in the University of Minnesota's Spring 2019 semester of CSCi 1933.
 */
public class QueryEvaluator {
    /**
     * Commonly used contructs that are used in compound statement patterns. The goal of these are to make the overall
     * patterns signficnatly more readable
     */
    private static final String
        WHITESPACE = "\\s+",
        OPTIONAL_WHITESPACE = "\\s*",
        WILDCARD = "\\s*(.*)\\s*",
        COMMA = OPTIONAL_WHITESPACE + "," + OPTIONAL_WHITESPACE,
        NAME = "(\\S*)";

    /**
     * Formal regex definitions for each of the statements which allow the statement to be parsed using a Matcher. For
     * more information on the semi-formal schema declaration above.
     */
    private static final Pattern
        CREATE_STATEMENT = Pattern.compile(OPTIONAL_WHITESPACE + "create" + WHITESPACE + "table" + WHITESPACE + NAME
                + OPTIONAL_WHITESPACE + "\\(" + OPTIONAL_WHITESPACE + WILDCARD + OPTIONAL_WHITESPACE + "\\)"
                + OPTIONAL_WHITESPACE + ";" + OPTIONAL_WHITESPACE),
        INSERT_STATEMENT = Pattern.compile(OPTIONAL_WHITESPACE + "insert" + WHITESPACE + "into" + WHITESPACE +  NAME
                + WHITESPACE + "values" + OPTIONAL_WHITESPACE + "\\(" + WILDCARD + "\\)" + OPTIONAL_WHITESPACE + ";"
                + OPTIONAL_WHITESPACE),
        LOAD_STATEMENT = Pattern.compile(OPTIONAL_WHITESPACE + "load" + WILDCARD + ";" + OPTIONAL_WHITESPACE),
        STORE_STATEMENT = Pattern.compile(OPTIONAL_WHITESPACE + "store" + WILDCARD + ";" + OPTIONAL_WHITESPACE),
        PRINT_STATEMENT = Pattern.compile(OPTIONAL_WHITESPACE + "print" + WILDCARD + ";" + OPTIONAL_WHITESPACE),
        SELECT_STATEMENT = Pattern.compile(OPTIONAL_WHITESPACE + "select" + OPTIONAL_WHITESPACE + "\\(" + WILDCARD
                + "\\)" + OPTIONAL_WHITESPACE + "from" + OPTIONAL_WHITESPACE + NAME + OPTIONAL_WHITESPACE + "where"
                + WILDCARD + ";" + OPTIONAL_WHITESPACE),
        EXIT_STATEMENT = Pattern.compile(OPTIONAL_WHITESPACE + "exit" + OPTIONAL_WHITESPACE + ";"
                + OPTIONAL_WHITESPACE);

    /**
     * Method that parses a given query and ensures that it conforms to the schema defined for the database system
     * @param query corresponds to a line of user entry which is desired to be interpreted as a query.
     * @return InterpretedQuery easily interfacable object containing the core information derived from parsing
     * the query. For more information view InterpretedQuery.java
     */
    public static InterpretedQuery evaluateQuery(String query) {
        Matcher matcher;

        if ((matcher = CREATE_STATEMENT.matcher(query)).matches()) {
            List<String> columnNames = new ArrayList<String>(),
                    columnTypes = new ArrayList<String>();
            Arrays.stream(matcher.group(2).split(OPTIONAL_WHITESPACE + "," + OPTIONAL_WHITESPACE))
                    .map(pair -> pair.split(WHITESPACE))
                    .forEach(splitPair -> {
                        columnNames.add(splitPair[0]);
                        columnTypes.add(splitPair[1]);
                    });
            return new InterpretedQuery(QueryType.CREATE_STATEMENT,
                    matcher.group(1),
                    columnNames.toArray(new String[0]),
                    columnTypes.toArray(new String[0]));
        } else if ((matcher = INSERT_STATEMENT.matcher(query)).matches()) {
            return new InterpretedQuery(QueryType.INSERT_STATEMENT,
                    matcher.group(1),
                    matcher.group(2).split(COMMA));
        } else if ((matcher = LOAD_STATEMENT.matcher(query)).matches()) {
            return new InterpretedQuery(QueryType.LOAD_STATEMENT,
                    matcher.group(1));
        } else if ((matcher = STORE_STATEMENT.matcher(query)).matches()) {
            return new InterpretedQuery(QueryType.STORE_STATEMENT,
                    matcher.group(1));
        } else if ((matcher = PRINT_STATEMENT.matcher(query)).matches()) {
            return new InterpretedQuery(QueryType.PRINT_STATEMENT,
                    matcher.group(1));
        } else if ((matcher = SELECT_STATEMENT.matcher(query)).matches()) {
            return new InterpretedQuery(QueryType.SELECT_STATEMENT,
                    matcher.group(2),
                    matcher.group(1).split(OPTIONAL_WHITESPACE + "," + OPTIONAL_WHITESPACE),
                    matcher.group(3));
        } else if (EXIT_STATEMENT.matcher(query).matches()) {
            return new InterpretedQuery(QueryType.EXIT_STATEMENT);
        } else {
            throw new RuntimeException("Query " + query + " is not a valid query");
        }
    }
}
