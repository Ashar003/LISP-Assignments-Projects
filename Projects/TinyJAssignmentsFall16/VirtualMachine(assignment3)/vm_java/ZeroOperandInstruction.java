package TJasn.virtualMachine;

import TJasn.OutputFileHandler;
import TJasn.TJ;
import TJasn.virtualMachine.Instruction;
import java.io.PrintWriter;

public abstract class ZeroOperandInstruction
extends Instruction {
    final void writeInstr() {
        TJ.output.getOutFileWriter().printf("%-8s", String.valueOf(this.address) + ":");
        TJ.output.getOutFileWriter().printf("%s%n", this.operationName);
    }

    public ZeroOperandInstruction() {
        super(null);
    }

    public ZeroOperandInstruction(String string) {
        super(string);
        this.writeInstr();
    }
}
