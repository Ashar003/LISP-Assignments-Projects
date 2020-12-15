package TJasn.virtualMachine;

import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.ZeroOperandInstruction;

public class GEinstr
extends ZeroOperandInstruction {
    void execute() {
        CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 1] = CodeInterpreter.EXPRSTACK[--CodeInterpreter.ESP - 1] >= CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP] ? 1 : 0;
    }

    public GEinstr() {
        super("GE");
    }

    static {
        GEinstr.demoClasses[GEinstr.demoClassCount++] = "GE";
    }
}

