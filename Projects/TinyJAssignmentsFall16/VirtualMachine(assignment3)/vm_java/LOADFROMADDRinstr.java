package TJasn.virtualMachine;

import TJasn.TJ;
import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.VirtualMachineHaltException;
import TJasn.virtualMachine.ZeroOperandInstruction;

public class LOADFROMADDRinstr
extends ZeroOperandInstruction {
    void execute() throws VirtualMachineHaltException {
        int n = CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 1];
        if (n >= CodeInterpreter.HMAX || n < 2147418112) {
            throw new VirtualMachineHaltException("RUNTIME ERROR: Invalid pointer value");
        }
        CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 1] = TJ.data[n - 2147418112];
    }

    public LOADFROMADDRinstr() {
        super("LOADFROMADDR");
    }

    static {
        LOADFROMADDRinstr.demoClasses[LOADFROMADDRinstr.demoClassCount++] = "LOADFROMADDR";
    }
}
