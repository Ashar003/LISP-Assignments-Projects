package TJasn.virtualMachine;

import static TJasn.virtualMachine.CodeInterpreter.*;

public class GTinstr extends ZeroOperandInstruction {

  void execute ()
  {
    /* ???????? */
    if(EXPRSTACK[--ESP - 1] > EXPRSTACK[ESP]) {
        EXPRSTACK[ESP - 1] = 1;
    } else {
        EXPRSTACK[ESP-1] = 0;
    }
    /* ???????? */
  }

  public GTinstr ()
  {
    super("GT");
  }
}

