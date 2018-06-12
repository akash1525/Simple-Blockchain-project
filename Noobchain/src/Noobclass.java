import java.util.ArrayList;
import java.io.IOException;
import com.google.gson.GsonBuilder;

public class Noobclass {

	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static int difficulty = 5;

	
	
	
	public static void main(String args[])throws IOException
{
	blockchain.add(new Block("Hi this is the first block", "0"));
	System.out.println("Trying to Mine Block 1...");
	blockchain.get(0).mineBlock(difficulty);
	
	blockchain.add(new Block("This is the 2nd block", blockchain.get(blockchain.size()-1).hash));
	System.out.println("Trying to Mine Block 2...");
	blockchain.get(1).mineBlock(difficulty);
	
	blockchain.add(new Block("Yo this is the 3rd block",blockchain.get(blockchain.size()-1).hash));
	System.out.println("Trying to Mine Block 3...");
	blockchain.get(2).mineBlock(difficulty);
	
	blockchain.add(new Block("Namaste this is the 4th block",blockchain.get(blockchain.size()-1).hash));
	System.out.println("Trying to Mine Block 4...");
	blockchain.get(3).mineBlock(difficulty);
	
	System.out.println("\n Blockchain is Valid: "+ isChainValid());
	
	String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
	System.out.println("The Block chain:");
	System.out.println(blockchainJson);
	
//	Block genesisBlock = new Block("This is the first block", "0");
//	System.out.println("Hash for Block 1: " + genesisBlock.hash);
//	
//
//	Block secondBlock = new Block("This is the second block", genesisBlock.hash);
//	System.out.println("Hash for Block 2: " + secondBlock.hash);
//	
//
//	Block thirdBlock = new Block("This is the first block", secondBlock.hash);
//	System.out.println("Hash for Block 3: " + thirdBlock.hash);
//	
//
//	Block fourthBlock = new Block("This is the first block", thirdBlock.hash);
//	System.out.println("Hash for Block 4: " + fourthBlock.hash);
	}
	
	public static Boolean isChainValid() 
	{
		Block currentBlock;
		Block previousBlock;
	
	//loop through block chain to check hashes
		for (int i =1 ; i< blockchain.size();i++)
		{
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			
			//compare registered hash and calculated hash
			if(!currentBlock.hash.equals(currentBlock.calculateHash())) {
				System.out.println("Current Hashes are not equal");
				return false;
			}
			
			//compare previous hash and registered previous hash
			
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("Previous Hashes are not equal");
				return false;
			}
		}
		return true;
	}
	
}
