package TJasn.virtualMachine;

import TJasn.virtualMachine.ZeroOperandInstruction;
import java.io.PrintStream;

public class WRITELNOPinstr
extends ZeroOperandInstruction {
    void execute() {
        System.out.println();
    }

    public WRITELNOPinstr() {
        super("WRITELNOP");
    }

    static {
        WRITELNOPinstr.demoClasses[WRITELNOPinstr.demoClassCount++] = "WRITELNOP";
    }
}