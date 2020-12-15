package TJasn.virtualMachine;

import TJasn.TJ;
import TJasn.virtualMachine.TwoOperandInstruction;
import java.io.PrintStream;

public class WRITESTRINGinstr
extends TwoOperandInstruction {
    void execute() {
        for (int i = this.firstOperand; i <= this.secondOperand; ++i) {
            System.out.print((char)TJ.data[i]);
        }
    }

    public WRITESTRINGinstr(int n, int n2) {
        super(n, n2, "WRITESTRING");
    }

    static {
        WRITESTRINGinstr.demoClasses[WRITESTRINGinstr.demoClassCount++] = "WRITESTRING";
    }
}

