package TJasn.virtualMachine;

import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.ZeroOperandInstruction;

public class MODinstr
extends ZeroOperandInstruction {
    void execute() {
        CodeInterpreter.EXPRSTACK[--CodeInterpreter.ESP - 1] = CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 1] % CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP];
    }

    public MODinstr() {
        super("MOD");
    }

    static {
        MODinstr.demoClasses[MODinstr.demoClassCount++] = "MOD";
    }
}
