package TJasn.virtualMachine;

import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.VirtualMachineHaltException;
import TJasn.virtualMachine.ZeroOperandInstruction;

public class ADDinstr
extends ZeroOperandInstruction {
    void execute() throws VirtualMachineHaltException {
        if ((CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 1] = CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 1] + CodeInterpreter.EXPRSTACK[--CodeInterpreter.ESP]) >= 2147428112) {
            throw new VirtualMachineHaltException("RUNTIME ERROR: Integer overflow");
        }
    }

    public ADDinstr() {
        super("ADD");
    }

    static {
        ADDinstr.demoClasses[ADDinstr.demoClassCount++] = "ADD";
    }
}

