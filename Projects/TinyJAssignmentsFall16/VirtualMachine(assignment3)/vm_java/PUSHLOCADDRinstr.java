package TJasn.virtualMachine;

import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.OneOperandInstruction;

public class PUSHLOCADDRinstr
extends OneOperandInstruction {
    void execute() {
        CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP++] = CodeInterpreter.FP + this.operand;
    }

    public PUSHLOCADDRinstr(int n) {
        super(n, "PUSHLOCADDR");
    }

    static {
        PUSHLOCADDRinstr.demoClasses[PUSHLOCADDRinstr.demoClassCount++] = "PUSHLOCADDR";
    }
}