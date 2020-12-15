package TJasn.virtualMachine;

import TJasn.virtualMachine.CodeInterpreter;
import TJasn.virtualMachine.ZeroOperandInstruction;

public class NEinstr
extends ZeroOperandInstruction {
    void execute() {
        CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP - 1] = CodeInterpreter.EXPRSTACK[--CodeInterpreter.ESP - 1] != CodeInterpreter.EXPRSTACK[CodeInterpreter.ESP] ? 1 : 0;
    }

    public NEinstr() {
        super("NE");
    }

    static {
        NEinstr.demoClasses[NEinstr.demoClassCount++] = "NE";
    }
}
