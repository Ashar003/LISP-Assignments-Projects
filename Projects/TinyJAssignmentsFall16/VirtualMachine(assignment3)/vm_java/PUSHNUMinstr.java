package TJasn.virtualMachine;

import TJ1asn.SourceFileErrorException;
import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.OneOperandInstruction;

public class PUSHNUMinstr
extends OneOperandInstruction {
    void execute() {
        CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP++] = this.operand;
    }

    public PUSHNUMinstr(int n) throws SourceFileErrorException {
        super(n, "PUSHNUM");
        if (this.operand >= 2147428112) {
            throw new SourceFileErrorException("Integer constant is too large.");
        }
    }

    static {
        PUSHNUMinstr.demoClasses[PUSHNUMinstr.demoClassCount++] = "PUSHNUM";
    }
}
