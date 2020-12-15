package TJasn.virtualMachine;

import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.ZeroOperandInstruction;

public class ORinstr
extends ZeroOperandInstruction {
    void execute() {
        CodeInterpreter.EXPRSTACK[--CodeInterpreter.ESP - 1] = CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 1] | CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP];
    }

    public ORinstr() {
        super("OR");
    }

    static {
        ORinstr.demoClasses[ORinstr.demoClassCount++] = "OR";
    }
}

