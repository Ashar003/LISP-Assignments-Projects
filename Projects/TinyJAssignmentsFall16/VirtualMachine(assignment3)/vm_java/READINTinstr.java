package TJasn.virtualMachine;

import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.VirtualMachineHaltException;
import TJasn.virtualMachine.ZeroOperandInstruction;
import java.util.Scanner;

public class READINTinstr
extends ZeroOperandInstruction {
    void execute() throws VirtualMachineHaltException {
        try {
            CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP++] = CodeInterpreter.input.nextInt();
            if (CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP++] >= 2147428112) {
                throw new VirtualMachineHaltException("RUNTIME ERROR: Integer constant is too large.");
            }
        }
        catch (NumberFormatException var1_1) {
            throw new VirtualMachineHaltException("RUNTIME ERROR: Bad integer input");
        }
    }

    public READINTinstr() {
        super("READINT");
    }
}

