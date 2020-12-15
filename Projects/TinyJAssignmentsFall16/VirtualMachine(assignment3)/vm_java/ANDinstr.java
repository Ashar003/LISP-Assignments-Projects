package TJasn.virtualMachine;

import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.ZeroOperandInstruction;

public class ANDinstr
extends ZeroOperandInstruction {
    void execute() {
        CodeInterpreter.EXPRSTACK[--CodeInterpreter.ESP - 1] = CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 1] & CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP];
    }

    public ANDinstr() {
        super("AND");
    }

    static {
        ANDinstr.demoClasses[ANDinstr.demoClassCount++] = "AND";
    }
}