package TJasn.virtualMachine;

import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.VirtualMachineHaltException;
import TJasn.virtualMachine.ZeroOperandInstruction;

public class CHANGESIGNinstr
extends ZeroOperandInstruction {
    void execute() throws VirtualMachineHaltException {
        CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 1] = CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 1] * -1;
        if (CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 1] >= 2147418112) {
            throw new VirtualMachineHaltException("RUNTIME ERROR: Integer overflow");
        }
    }

    public CHANGESIGNinstr() {
        super("CHANGESIGN");
    }

    static {
        CHANGESIGNinstr.demoClasses[CHANGESIGNinstr.demoClassCount++] = "CHANGESIGN";
    }
}
