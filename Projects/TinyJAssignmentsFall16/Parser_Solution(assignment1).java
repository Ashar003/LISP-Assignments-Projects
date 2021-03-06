package TJ1asn;

import TJ1asn.OutputFileHandler;
import TJ1asn.Parser;
import TJ1asn.SourceFileErrorException;
import TJ1asn.TJ;
import TJlexer.LexicalAnalyzer;
import TJlexer.Symbols;

public final class Parser {
    private static void accept(Symbols symbols) throws SourceFileErrorException {
        if (LexicalAnalyzer.getCurrentToken() != symbols) {
            throw new SourceFileErrorException("Something's wrong--maybe the following token is missing: " + symbols.symbolRepresentationForOutputFile);
        }
        LexicalAnalyzer.nextToken();
    }

    static void program() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTprogram);
        TJ.output.incTreeDepth();
        if (LexicalAnalyzer.getCurrentToken() == Symbols.IMPORT) {
            Parser.importStmt();
        }
        Parser.accept(Symbols.CLASS);
        Parser.accept(Symbols.IDENT);
        Parser.accept(Symbols.LBRACE);
        while (LexicalAnalyzer.getCurrentToken() == Symbols.STATIC) {
            Parser.dataFieldDecl();
        }
        Parser.mainDecl();
        while (LexicalAnalyzer.getCurrentToken() == Symbols.STATIC) {
            Parser.methodDecl();
        }
        Parser.accept(Symbols.RBRACE);
        TJ.output.decTreeDepth();
    }

    private static void importStmt() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTimport);
        TJ.output.incTreeDepth();
        Parser.accept(Symbols.IMPORT);
        Parser.accept(Symbols.JAVA);
        Parser.accept(Symbols.DOT);
        Parser.accept(Symbols.UTIL);
        Parser.accept(Symbols.DOT);
        Parser.accept(Symbols.SCANNER);
        Parser.accept(Symbols.SEMICOLON);
        TJ.output.decTreeDepth();
    }

    private static void dataFieldDecl() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTdataFieldDecl);
        TJ.output.incTreeDepth();
        Parser.accept(Symbols.STATIC);
        Parser.varDecl();
        TJ.output.decTreeDepth();
    }

    private static void varDecl() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTvarDecl);
        TJ.output.incTreeDepth();
        if (LexicalAnalyzer.getCurrentToken() == Symbols.INT) {
            LexicalAnalyzer.nextToken();
            Parser.singleVarDecl();
            while (LexicalAnalyzer.getCurrentToken() == Symbols.COMMA) {
                LexicalAnalyzer.nextToken();
                Parser.singleVarDecl();
            }
            Parser.accept(Symbols.SEMICOLON);
        } else if (LexicalAnalyzer.getCurrentToken() == Symbols.SCANNER) {
            LexicalAnalyzer.nextToken();
            if (LexicalAnalyzer.getCurrentToken() != Symbols.IDENT) {
                throw new SourceFileErrorException("Scanner name expected");
            }
            LexicalAnalyzer.nextToken();
            Parser.accept(Symbols.BECOMES);
            Parser.accept(Symbols.NEW);
            Parser.accept(Symbols.SCANNER);
            Parser.accept(Symbols.LPAREN);
            Parser.accept(Symbols.SYSTEM);
            Parser.accept(Symbols.DOT);
            Parser.accept(Symbols.IN);
            Parser.accept(Symbols.RPAREN);
            Parser.accept(Symbols.SEMICOLON);
        } else {
            throw new SourceFileErrorException("\"int\" or \"Scanner\" expected");
        }
        TJ.output.decTreeDepth();
    }

    private static void singleVarDecl() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTsingleVarDecl);
        TJ.output.incTreeDepth();
        if (LexicalAnalyzer.getCurrentToken() == Symbols.IDENT) {
            LexicalAnalyzer.nextToken();
            while (LexicalAnalyzer.getCurrentToken() == Symbols.LBRACKET) {
                LexicalAnalyzer.nextToken();
                Parser.accept(Symbols.RBRACKET);
            }
            if (LexicalAnalyzer.getCurrentToken() == Symbols.BECOMES) {
                LexicalAnalyzer.nextToken();
                Parser.expr3();
            }
        } else {
            throw new SourceFileErrorException("Variable name expected");
        }
        TJ.output.decTreeDepth();
    }

    private static void mainDecl() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTmainDecl);
        TJ.output.incTreeDepth();
        Parser.accept(Symbols.PUBLIC);
        Parser.accept(Symbols.STATIC);
        Parser.accept(Symbols.VOID);
        Parser.accept(Symbols.MAIN);
        Parser.accept(Symbols.LPAREN);
        Parser.accept(Symbols.STRING);
        Parser.accept(Symbols.IDENT);
        Parser.accept(Symbols.LBRACKET);
        Parser.accept(Symbols.RBRACKET);
        Parser.accept(Symbols.RPAREN);
        Parser.compoundStmt();
        TJ.output.decTreeDepth();
    }

    private static void methodDecl() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTmethodDecl);
        TJ.output.incTreeDepth();
        Parser.accept(Symbols.STATIC);
        if (LexicalAnalyzer.getCurrentToken() == Symbols.INT) {
            LexicalAnalyzer.nextToken();
            while (LexicalAnalyzer.getCurrentToken() == Symbols.LBRACKET) {
                LexicalAnalyzer.nextToken();
                Parser.accept(Symbols.RBRACKET);
            }
        } else {
            Parser.accept(Symbols.VOID);
        }
        if (LexicalAnalyzer.getCurrentToken() != Symbols.IDENT) {
            throw new SourceFileErrorException("Method name expected");
        }
        LexicalAnalyzer.nextToken();
        Parser.accept(Symbols.LPAREN);
        Parser.parameterDeclList();
        Parser.accept(Symbols.RPAREN);
        Parser.compoundStmt();
        TJ.output.decTreeDepth();
    }

    private static void parameterDeclList() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTparameterDeclList);
        TJ.output.incTreeDepth();
        if (LexicalAnalyzer.getCurrentToken() == Symbols.INT) {
            Parser.parameterDecl();
            while (LexicalAnalyzer.getCurrentToken() == Symbols.COMMA) {
                LexicalAnalyzer.nextToken();
                Parser.parameterDecl();
            }
        } else {
            TJ.output.printSymbol(Symbols.EMPTY);
        }
        TJ.output.decTreeDepth();
    }

    private static void parameterDecl() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTparameterDecl);
        TJ.output.incTreeDepth();
        Parser.accept(Symbols.INT);
        Parser.accept(Symbols.IDENT);
        while (LexicalAnalyzer.getCurrentToken() == Symbols.LBRACKET) {
            LexicalAnalyzer.nextToken();
            Parser.accept(Symbols.RBRACKET);
        }
        TJ.output.decTreeDepth();
    }

    private static void compoundStmt() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTcompoundStmt);
        TJ.output.incTreeDepth();
        Parser.accept(Symbols.LBRACE);
        while (LexicalAnalyzer.getCurrentToken() != Symbols.RBRACE) {
            Parser.statement();
        }
        LexicalAnalyzer.nextToken();
        TJ.output.decTreeDepth();
    }

    private static void statement() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTstatement);
        TJ.output.incTreeDepth();
        switch (1.$SwitchMap$TJlexer$Symbols[LexicalAnalyzer.getCurrentToken().ordinal()]) {
            case 1: {
                LexicalAnalyzer.nextToken();
                break;
            }
            case 2: {
                LexicalAnalyzer.nextToken();
                if (LexicalAnalyzer.getCurrentToken() != Symbols.SEMICOLON) {
                    Parser.expr3();
                }
                Parser.accept(Symbols.SEMICOLON);
                break;
            }
            case 3: 
            case 4: {
                Parser.varDecl();
                break;
            }
            case 5: {
                Parser.assignmentOrInvoc();
                break;
            }
            case 6: {
                Parser.compoundStmt();
                break;
            }
            case 7: {
                Parser.ifStmt();
                break;
            }
            case 8: {
                Parser.whileStmt();
                break;
            }
            case 9: {
                Parser.outputStmt();
                break;
            }
            default: {
                throw new SourceFileErrorException("Expected first token of a <statement>, not " + LexicalAnalyzer.getCurrentToken().symbolRepresentationForOutputFile);
            }
        }
        TJ.output.decTreeDepth();
    }

    private static void assignmentOrInvoc() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTassignmentOrInvoc);
        TJ.output.incTreeDepth();
        Parser.accept(Symbols.IDENT);
        if (LexicalAnalyzer.getCurrentToken() != Symbols.LPAREN) {
            while (LexicalAnalyzer.getCurrentToken() == Symbols.LBRACKET) {
                LexicalAnalyzer.nextToken();
                Parser.expr3();
                Parser.accept(Symbols.RBRACKET);
            }
            Parser.accept(Symbols.BECOMES);
            Parser.expr3();
            Parser.accept(Symbols.SEMICOLON);
        } else {
            Parser.argumentList();
            Parser.accept(Symbols.SEMICOLON);
        }
        TJ.output.decTreeDepth();
    }

    private static void argumentList() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTargumentList);
        TJ.output.incTreeDepth();
        Parser.accept(Symbols.LPAREN);
        if (LexicalAnalyzer.getCurrentToken() != Symbols.RPAREN) {
            Parser.expr3();
            while (LexicalAnalyzer.getCurrentToken() == Symbols.COMMA) {
                LexicalAnalyzer.nextToken();
                Parser.expr3();
            }
        }
        Parser.accept(Symbols.RPAREN);
        TJ.output.decTreeDepth();
    }

    private static void ifStmt() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTifStmt);
        TJ.output.incTreeDepth();
        Parser.accept(Symbols.IF);
        Parser.accept(Symbols.LPAREN);
        Parser.expr7();
        Parser.accept(Symbols.RPAREN);
        Parser.statement();
        if (LexicalAnalyzer.getCurrentToken() == Symbols.ELSE) {
            LexicalAnalyzer.nextToken();
            Parser.statement();
        }
        TJ.output.decTreeDepth();
    }

    private static void whileStmt() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTwhileStmt);
        TJ.output.incTreeDepth();
        Parser.accept(Symbols.WHILE);
        Parser.accept(Symbols.LPAREN);
        Parser.expr7();
        Parser.accept(Symbols.RPAREN);
        Parser.statement();
        TJ.output.decTreeDepth();
    }

    private static void outputStmt() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NToutputStmt);
        TJ.output.incTreeDepth();
        Parser.accept(Symbols.SYSTEM);
        Parser.accept(Symbols.DOT);
        Parser.accept(Symbols.OUT);
        Parser.accept(Symbols.DOT);
        switch (1.$SwitchMap$TJlexer$Symbols[LexicalAnalyzer.getCurrentToken().ordinal()]) {
            case 10: {
                LexicalAnalyzer.nextToken();
                Parser.accept(Symbols.LPAREN);
                Parser.printArgument();
                Parser.accept(Symbols.RPAREN);
                Parser.accept(Symbols.SEMICOLON);
                break;
            }
            case 11: {
                LexicalAnalyzer.nextToken();
                Parser.accept(Symbols.LPAREN);
                if (LexicalAnalyzer.getCurrentToken() != Symbols.RPAREN) {
                    Parser.printArgument();
                }
                Parser.accept(Symbols.RPAREN);
                Parser.accept(Symbols.SEMICOLON);
                break;
            }
            default: {
                throw new SourceFileErrorException("print() or println() expected, not " + LexicalAnalyzer.getCurrentToken().symbolRepresentationForOutputFile);
            }
        }
        TJ.output.decTreeDepth();
    }

    private static void printArgument() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTprintArgument);
        TJ.output.incTreeDepth();
        if (LexicalAnalyzer.getCurrentToken() == Symbols.CHARSTRING) {
            LexicalAnalyzer.nextToken();
        } else {
            Parser.expr3();
        }
        TJ.output.decTreeDepth();
    }

    private static void expr7() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTexpr7);
        TJ.output.incTreeDepth();
        Parser.expr6();
        while (LexicalAnalyzer.getCurrentToken() == Symbols.OR) {
            LexicalAnalyzer.nextToken();
            Parser.expr6();
        }
        TJ.output.decTreeDepth();
    }

    private static void expr6() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTexpr6);
        TJ.output.incTreeDepth();
        Parser.expr5();
        while (LexicalAnalyzer.getCurrentToken() == Symbols.AND) {
            LexicalAnalyzer.nextToken();
            Parser.expr5();
        }
        TJ.output.decTreeDepth();
    }

    private static void expr5() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTexpr5);
        TJ.output.incTreeDepth();
        Parser.expr4();
        while (LexicalAnalyzer.getCurrentToken() == Symbols.EQ || LexicalAnalyzer.getCurrentToken() == Symbols.NE) {
            LexicalAnalyzer.nextToken();
            Parser.expr4();
        }
        TJ.output.decTreeDepth();
    }

    private static void expr4() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTexpr4);
        TJ.output.incTreeDepth();
        Parser.expr3();
        if (LexicalAnalyzer.getCurrentToken() == Symbols.LT || LexicalAnalyzer.getCurrentToken() == Symbols.LE || LexicalAnalyzer.getCurrentToken() == Symbols.GT || LexicalAnalyzer.getCurrentToken() == Symbols.GE) {
            LexicalAnalyzer.nextToken();
            Parser.expr3();
        }
        TJ.output.decTreeDepth();
    }

    private static void expr3() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTexpr3);
        TJ.output.incTreeDepth();
        Parser.expr2();
        while (LexicalAnalyzer.getCurrentToken() == Symbols.PLUS || LexicalAnalyzer.getCurrentToken() == Symbols.MINUS) {
            LexicalAnalyzer.nextToken();
            Parser.expr2();
        }
        TJ.output.decTreeDepth();
    }

    private static void expr2() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTexpr2);
        TJ.output.incTreeDepth();
        Parser.expr1();
        while (LexicalAnalyzer.getCurrentToken() == Symbols.TIMES || LexicalAnalyzer.getCurrentToken() == Symbols.DIV || LexicalAnalyzer.getCurrentToken() == Symbols.MOD) {
            LexicalAnalyzer.nextToken();
            Parser.expr1();
        }
        TJ.output.decTreeDepth();
    }

    private static void expr1() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTexpr1);
        TJ.output.incTreeDepth();
        switch (1.$SwitchMap$TJlexer$Symbols[LexicalAnalyzer.getCurrentToken().ordinal()]) {
            case 12: {
                LexicalAnalyzer.nextToken();
                break;
            }
            case 5: {
                LexicalAnalyzer.nextToken();
                if (LexicalAnalyzer.getCurrentToken() == Symbols.DOT) {
                    LexicalAnalyzer.nextToken();
                    Parser.accept(Symbols.NEXTINT);
                    Parser.accept(Symbols.LPAREN);
                    Parser.accept(Symbols.RPAREN);
                    break;
                }
                if (LexicalAnalyzer.getCurrentToken() == Symbols.LPAREN) {
                    Parser.argumentList();
                }
                while (LexicalAnalyzer.getCurrentToken() == Symbols.LBRACKET) {
                    LexicalAnalyzer.nextToken();
                    Parser.expr3();
                    Parser.accept(Symbols.RBRACKET);
                }
                break;
            }
            case 13: {
                LexicalAnalyzer.nextToken();
                Parser.expr7();
                Parser.accept(Symbols.RPAREN);
                break;
            }
            case 14: 
            case 15: 
            case 16: {
                LexicalAnalyzer.nextToken();
                Parser.expr1();
                break;
            }
            case 17: {
                LexicalAnalyzer.nextToken();
                Parser.accept(Symbols.INT);
                Parser.accept(Symbols.LBRACKET);
                Parser.expr3();
                Parser.accept(Symbols.RBRACKET);
                while (LexicalAnalyzer.getCurrentToken() == Symbols.LBRACKET) {
                    LexicalAnalyzer.nextToken();
                    Parser.accept(Symbols.RBRACKET);
                }
                break;
            }
            case 18: {
                LexicalAnalyzer.nextToken();
                break;
            }
            default: {
                throw new SourceFileErrorException("Malformed expression");
            }
        }
        TJ.output.decTreeDepth();
    }
}