package TJasn.virtualMachine;

import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.ZeroOperandInstruction;

public class NOTinstr
extends ZeroOperandInstruction {
    void execute() {
        CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 1] = CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 1] == 0 ? 1 : 0;
    }

    public NOTinstr() {
        super("NOT");
    }

    static {
        NOTinstr.demoClasses[NOTinstr.demoClassCount++] = "NOT";
    }
}