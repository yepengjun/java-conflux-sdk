package conflux.web3j.contract;

import java.math.BigInteger;

import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.generated.Uint256;

import conflux.web3j.Account;

public class ERC20Executor {
	
	private Account account;
	private String contract;
	
	public ERC20Executor(Account account, String erc20Address) {
		this.account = account;
		this.contract = erc20Address;
	}
	
	public String transfer(BigInteger gasLimit, String recipient, BigInteger amount) throws Exception {
		return this.account.call(this.contract, gasLimit, "transfer", new Address(recipient), new Uint256(amount));
	}
	
	public String approve(BigInteger gasLimit, String spender, BigInteger amount) throws Exception {
		return this.account.call(this.contract, gasLimit, "approve", new Address(spender), new Uint256(amount));
	}
	
	public String transferFrom(BigInteger gasLimit, String sender, String recipient, BigInteger amount) throws Exception {
		return this.account.call(this.contract, gasLimit, "transferFrom", new Address(sender), new Address(recipient), new Uint256(amount));
	}

}
