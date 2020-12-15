package TJasn.virtualMachine;

import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.ZeroOperandInstruction;
import java.io.PrintStream;

public class WRITEINTinstr
extends ZeroOperandInstruction {
    void execute() {
        System.out.print(CodeInterpreter.EXPRSTACK[--CodeInterpreter.ESP]);
    }

    public WRITEINTinstr() {
        super("WRITEINT");
    }

    static {
        WRITEINTinstr.demoClasses[WRITEINTinstr.demoClassCount++] = "WRITEINT";
    }
}

