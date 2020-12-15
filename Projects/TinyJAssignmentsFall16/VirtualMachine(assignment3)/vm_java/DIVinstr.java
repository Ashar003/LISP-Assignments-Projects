package TJasn.virtualMachine;

import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.ZeroOperandInstruction;

public class DIVinstr
extends ZeroOperandInstruction {
    void execute() {
        CodeInterpreter.EXPRSTACK[--CodeInterpreter.ESP - 1] = CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 1] / CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP];
    }

    public DIVinstr() {
        super("DIV");
    }

    static {
        DIVinstr.demoClasses[DIVinstr.demoClassCount++] = "DIV";
    }
}
