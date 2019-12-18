package in.inzenjer.BlockChain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;



public class InitializeBlockChain {

	public static int HASH_TAG_VALUE;
	public static List<Block> initialize(Vector<String> encryptedData) throws SQLException {
		List<Block> blockChainList = new ArrayList<>();
		for (int i = 0; i < encryptedData.size(); i++) {
			if (i == 0) {
				Block genesis = new Block(encryptedData.get(i), 0);
				blockChainList.add(genesis);
			} else {
				Block helloBlock = new Block(encryptedData.get(i),
						blockChainList.get(blockChainList.size() - 1).getHash());
				blockChainList.add(helloBlock);
			}
			
			HASH_TAG_VALUE=blockChainList.get(i).getHash();
			//RecordBlockChain.recordTransaction(i);
		}
		return blockChainList;
	}

	public static boolean validate(List<Block> blockChain) {
		boolean result = true;
		Block lastBlock = null;
		for (int i = blockChain.size() - 1; i >= 0; i--) {
			if (lastBlock == null) {
				lastBlock = blockChain.get(i);
			} else {
				Block current = blockChain.get(i);
				if (lastBlock.getPreviousHash() != current.getHash()) {
					result = false;
					break;
				}
				lastBlock = current;
			}
		}
		return result;
	}
}
