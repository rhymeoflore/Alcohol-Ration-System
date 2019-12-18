package in.inzenjer.BlockChain;

import java.io.Serializable;
import java.util.Arrays;

import lombok.Getter;
import lombok.ToString;
@Getter
@ToString 
public class Transaction implements Serializable {
	private String tid;
	private String bevid;
	private String products[];
	private String date;
	private int previousHash;
	private int hash;
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getBevid() {
		return bevid;
	}
	public void setBevid(String bevid) {
		this.bevid = bevid;
	}
	public String[] getProducts() {
		return products;
	}
	public void setProducts(String[] products) {
		this.products = products;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPreviousHash() {
		return previousHash;
	}
	public void setPreviousHash(int previousHash) {
		this.previousHash = previousHash;
	}
	public int getHash() {
		return hash;
	}
	public void setHash(int hash) {
		this.hash = hash;
	}
	
	public Transaction(String tid,String[] products, String date,int previousHash, String bevID) {
        this.tid=tid;
		this.products = products;
        this.date=date;
        this.previousHash = previousHash;
        this.bevid=bevID;
        // Mix the content of this block with previous hash to create the hash of this new block
        // and that's what makes it block chain
        this.hash  = Arrays.hashCode(new Integer[]{products.hashCode(), previousHash});
    }

}
