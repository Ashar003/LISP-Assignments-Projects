package TJasn.virtualMachine;

import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.OneOperandInstruction;

public class JUMPinstr
extends OneOperandInstruction {
    void execute() {
        CodeInterpreter.PC = this.operand;
    }

    public JUMPinstr(int n) {
        super(n, "JUMP");
    }

    static {
        JUMPinstr.demoClasses[JUMPinstr.demoClassCount++] = "JUMP";
    }
}

