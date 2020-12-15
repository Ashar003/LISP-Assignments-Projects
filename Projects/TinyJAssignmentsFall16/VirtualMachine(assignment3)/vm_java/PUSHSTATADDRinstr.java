package TJasn.virtualMachine;

import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.OneOperandInstruction;

public class PUSHSTATADDRinstr
extends OneOperandInstruction {
    void execute() {
        CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP++] = this.operand + 2147418112;
    }

    public PUSHSTATADDRinstr(int n) {
        super(n, "PUSHSTATADDR");
    }

    static {
        PUSHSTATADDRinstr.demoClasses[PUSHSTATADDRinstr.demoClassCount++] = "PUSHSTATADDR";
    }
}
