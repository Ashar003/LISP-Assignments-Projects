package TJasn.virtualMachine;

import TJasn.TJ;
import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.OneOperandInstruction;

public class RETURNinstr
extends OneOperandInstruction {
    void execute() {
        CodeInterpreter.ASP = CodeInterpreter.FP;
        CodeInterpreter.FP = TJ.data[CodeInterpreter.ASP-- - 2147418112];
        CodeInterpreter.PC = TJ.data[CodeInterpreter.ASP - 2147418112];
        CodeInterpreter.ASP -= this.operand;
    }

    public RETURNinstr(int n) {
        super(n, "RETURN");
    }

    static {
        RETURNinstr.demoClasses[RETURNinstr.demoClassCount++] = "RETURN";
    }
}
