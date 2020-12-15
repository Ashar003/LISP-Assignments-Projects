package TJasn.virtualMachine;

import TJasn.TJ;
import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.OneOperandInstruction;
import TJasn.virtualMachine.VirtualMachineHaltException;

public class INITSTKFRMinstr
extends OneOperandInstruction {
    void execute() throws VirtualMachineHaltException {
        TJ.data[CodeInterpreter.ASP - 2147418112] = CodeInterpreter.FP;
        CodeInterpreter.FP = CodeInterpreter.ASP++;
        if ((CodeInterpreter.ASP += this.operand) - 2147418112 > 10000) {
            throw new VirtualMachineHaltException("RUNTIME ERROR: Activation record stack overflow");
        }
    }

    public INITSTKFRMinstr(int n) {
        super(n, "INITSTKFRM");
    }

    static {
        INITSTKFRMinstr.demoClasses[INITSTKFRMinstr.demoClassCount++] = "INITSTKFRM";
    }
}

