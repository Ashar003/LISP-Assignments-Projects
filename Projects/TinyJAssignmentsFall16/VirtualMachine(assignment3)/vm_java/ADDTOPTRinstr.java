package TJasn.virtualMachine;

import TJasn.TJ;
import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.VirtualMachineHaltException;
import TJasn.virtualMachine.ZeroOperandInstruction;

public class ADDTOPTRinstr
extends ZeroOperandInstruction {
    void execute() throws VirtualMachineHaltException {
        int n = TJ.data[CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 2] - 1 - 2147418112] - 1;
        if (CodeInterpreter.EXPRSTACK[--CodeInterpreter.ESP] < 0) {
            throw new VirtualMachineHaltException("RUNTIME ERROR: Array index is negative");
        }
        CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 1] = CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 1] + CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP];
        if (CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 1] > n) {
            throw new VirtualMachineHaltException("RUNTIME ERROR: Array index is greater than or equal to array's length");
        }
    }

    public ADDTOPTRinstr() {
        super("ADDTOPTR");
    }
}
