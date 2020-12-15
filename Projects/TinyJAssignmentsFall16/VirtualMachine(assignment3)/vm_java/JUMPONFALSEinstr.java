package TJasn.virtualMachine;

import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.OneOperandInstruction;

public class JUMPONFALSEinstr
extends OneOperandInstruction {
    void execute() {
        if (CodeInterpreter.EXPRSTACK[--CodeInterpreter.ESP] == 0) {
            CodeInterpreter.PC = this.operand;
        }
    }

    public JUMPONFALSEinstr(int n) {
        super(n, "JUMPONFALSE");
    }

    static {
        JUMPONFALSEinstr.demoClasses[JUMPONFALSEinstr.demoClassCount++] = "JUMPONFALSE";
    }
}
