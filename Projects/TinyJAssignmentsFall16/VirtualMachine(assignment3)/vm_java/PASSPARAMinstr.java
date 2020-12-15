package TJasn.virtualMachine;

import TJasn.TJ;
import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.VirtualMachineHaltException;
import TJasn.virtualMachine.ZeroOperandInstruction;

public class PASSPARAMinstr
extends ZeroOperandInstruction {
    void execute() throws VirtualMachineHaltException {
        TJ.data[CodeInterpreter.ASP++ - 2147418112] = CodeInterpreter.EXPRSTACK[--CodeInterpreter.ESP];
        if (CodeInterpreter.ASP - 2147418112 > 10000) {
            throw new VirtualMachineHaltException("RUNTIME ERROR: Activation record stack overflow");
        }
    }

    public PASSPARAMinstr() {
        super("PASSPARAM");
    }

    static {
        PASSPARAMinstr.demoClasses[PASSPARAMinstr.demoClassCount++] = "PASSPARAM";
    }
}
