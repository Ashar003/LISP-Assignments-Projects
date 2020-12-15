package TJasn.virtualMachine;

import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.VirtualMachineHaltException;
import TJasn.virtualMachine.ZeroOperandInstruction;

public class SUBinstr
extends ZeroOperandInstruction {
    void execute() throws VirtualMachineHaltException {
        if ((CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 1] = CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 1] - CodeInterpreter.EXPRSTACK[--CodeInterpreter.ESP]) >= 2147428112) {
            throw new VirtualMachineHaltException("RUNTIME ERROR: Integer overflow");
        }
    }

    public SUBinstr() {
        super("SUB");
    }

    static {
        SUBinstr.demoClasses[SUBinstr.demoClassCount++] = "SUB";
    }
}

