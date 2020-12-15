package TJasn.virtualMachine;

import TJasn.TJ;
import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.VirtualMachineHaltException;
import TJasn.virtualMachine.ZeroOperandInstruction;

public class SAVETOADDRinstr
extends ZeroOperandInstruction {
    void execute() throws VirtualMachineHaltException {
        int n = CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 2];
        if (n >= CodeInterpreter.HMAX || n < 2147418112) {
            throw new VirtualMachineHaltException("RUNTIME ERROR: Invalid pointer value");
        }
        TJ.data[n - 2147418112] = CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 1];
        CodeInterpreter.ESP -= 2;
    }

    public SAVETOADDRinstr() {
        super("SAVETOADDR");
    }

    static {
        SAVETOADDRinstr.demoClasses[SAVETOADDRinstr.demoClassCount++] = "SAVETOADDR";
    }
}

