package in.inzenjer.BlockChain;

import java.util.ArrayList;
import java.util.List;

public class ValidateBlockChain {
	public static boolean validate(ArrayList<Transaction> blocks) {
        boolean result = true;
        Transaction lastBlock = null;
        for(int i = blocks.size() -1; i >= 0; i--) {
            if(lastBlock == null) {
                lastBlock = blocks.get(i);
            }
            else {
            	Transaction current = blocks.get(i);
                if(lastBlock.getPreviousHash() != current.getHash()) {
                	System.out.println("mismatch in "+i+" and "+(i+1)+" block");
                    result = false;
                    break;
                }
                lastBlock = current;
            }
        }
        return result;
    }

}
