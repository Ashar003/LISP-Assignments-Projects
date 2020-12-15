package TJasn.virtualMachine;

import TJasn.TJ;
import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.OneOperandInstruction;

public class CALLSTATMETHODinstr
extends OneOperandInstruction {
    void execute() {
        TJ.data[CodeInterpreter.ASP++ - 2147418112] = CodeInterpreter.PC;
        CodeInterpreter.PC = this.operand;
    }

    public CALLSTATMETHODinstr(int n) {
        super(n, "CALLSTATMETHOD");
    }

    static {
        CALLSTATMETHODinstr.demoClasses[CALLSTATMETHODinstr.demoClassCount++] = "CALLSTATMETHOD";
    }
}