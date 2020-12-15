package TJasn.virtualMachine;

import TJasn.TJ;

public class WRITESTRINGinstr extends TwoOperandInstruction {

  void execute ()
  {
    /* ???????? */
    for(int a = this.firstOperand; a <= this.secondOperand; a++) {
        System.out.print((char)TJ.data[a]);
    }
    /* ???????? */
  }

  public WRITESTRINGinstr (int startOffset, int endOffset)
  {
    super(startOffset, endOffset, "WRITESTRING");
  }
}

