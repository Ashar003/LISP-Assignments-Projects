package TJasn.virtualMachine;

import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.ZeroOperandInstruction;

public class LTinstr
extends ZeroOperandInstruction {
    void execute() {
        CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 1] = CodeInterpreter.EXPRSTACK[--CodeInterpreter.ESP - 1] < CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP] ? 1 : 0;
    }

    public LTinstr() {
        super("LT");
    }

    static {
        LTinstr.demoClasses[LTinstr.demoClassCount++] = "LT";
    }
}