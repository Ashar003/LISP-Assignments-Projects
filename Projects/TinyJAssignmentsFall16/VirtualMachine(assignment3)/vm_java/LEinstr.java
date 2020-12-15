package TJasn.virtualMachine;

import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.ZeroOperandInstruction;

public class LEinstr
extends ZeroOperandInstruction {
    void execute() {
        CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 1] = CodeInterpreter.EXPRSTACK[--CodeInterpreter.ESP - 1] <= CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP] ? 1 : 0;
    }

    public LEinstr() {
        super("LE");
    }

    static {
        LEinstr.demoClasses[LEinstr.demoClassCount++] = "LE";
    }
}
