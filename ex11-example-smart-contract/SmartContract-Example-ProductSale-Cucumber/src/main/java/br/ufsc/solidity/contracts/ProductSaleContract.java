package br.ufsc.solidity.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.2.0.
 */
public class ProductSaleContract extends Contract {
    private static final String BINARY = "608060405260008054600160a060020a031916331790553480156200002357600080fd5b5060405162000f3b38038062000f3b8339810160409081528151602080840151928401516060850151928501805190959485019491820193909101916200007091600191870190620003b7565b50825162000086906002906020860190620003b7565b5081516200009c906003906020850190620003b7565b5060405160200180807f42524c000000000000000000000000000000000000000000000000000000000081525060030190506040516020818303038152906040526040518082805190602001908083835b602083106200010e5780518252601f199092019160209182019101620000ed565b51815160209384036101000a60001901801990921691161790526040519190930181900381208651909550869450908301928392508401908083835b602083106200016b5780518252601f1990920191602091820191016200014a565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040516020818303038152906040526040518082805190602001908083835b60208310620001d05780518252601f199092019160209182019101620001af565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390206000191614156200022357600480546002919060ff19166001835b0217905550620003ad565b60405160200180807f43414e000000000000000000000000000000000000000000000000000000000081525060030190506040516020818303038152906040526040518082805190602001908083835b60208310620002945780518252601f19909201916020918201910162000273565b51815160209384036101000a60001901801990921691161790526040519190930181900381208651909550869450908301928392508401908083835b60208310620002f15780518252601f199092019160209182019101620002d0565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040516020818303038152906040526040518082805190602001908083835b60208310620003565780518252601f19909201916020918201910162000335565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040518091039020600019161415620003a257600480546001919060ff1916828062000218565b6004805460ff191690555b505050506200045c565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10620003fa57805160ff19168380011785556200042a565b828001600101855582156200042a579182015b828111156200042a5782518255916020019190600101906200040d565b50620004389291506200043c565b5090565b6200045991905b8082111562000438576000815560010162000443565b90565b610acf806200046c6000396000f3006080604052600436106100775763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663603daf9a811461007c5780636945c1fd146101065780639481da531461013f578063a0597ca914610166578063dbd0e1b61461024a578063ff3c1a8f1461025f575b600080fd5b34801561008857600080fd5b50610091610274565b6040805160208082528351818301528351919283929083019185019080838360005b838110156100cb5781810151838201526020016100b3565b50505050905090810190601f1680156100f85780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561011257600080fd5b5061011b610308565b6040518082600281111561012b57fe5b60ff16815260200191505060405180910390f35b34801561014b57600080fd5b50610154610311565b60408051918252519081900360200190f35b34801561017257600080fd5b506040805160206004803580820135601f810184900484028501840190955284845261024894369492936024939284019190819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a99988101979196509182019450925082915084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a999881019791965091820194509250829150840183828082843750949750508435955050506020830135926040013591506103179050565b005b34801561025657600080fd5b506100916108e3565b34801561026b57600080fd5b50610091610943565b60028054604080516020601f60001961010060018716150201909416859004938401819004810282018101909252828152606093909290918301828280156102fd5780601f106102d2576101008083540402835291602001916102fd565b820191906000526020600020905b8154815290600101906020018083116102e057829003601f168201915b505050505090505b90565b60045460ff1690565b60055490565b61031f6109a4565b86815260208082018790523360408084019190915280517f4b670000000000000000000000000000000000000000000000000000000000008184015281518082036002018152602290910191829052805190928291908401908083835b6020831061039b5780518252601f19909201916020918201910161037c565b51815160209384036101000a60001901801990921691161790526040519190930181900381208a519095508a9450908301928392508401908083835b602083106103f65780518252601f1990920191602091820191016103d7565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040516020818303038152906040526040518082805190602001908083835b602083106104595780518252601f19909201916020918201910161043a565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390206000191614156104ac576060810160005b908160028111156104a457fe5b905250610792565b60405160200180807f4c6974746572000000000000000000000000000000000000000000000000000081525060060190506040516020818303038152906040526040518082805190602001908083835b6020831061051b5780518252601f1990920191602091820191016104fc565b51815160209384036101000a60001901801990921691161790526040519190930181900381208a519095508a9450908301928392508401908083835b602083106105765780518252601f199092019160209182019101610557565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040516020818303038152906040526040518082805190602001908083835b602083106105d95780518252601f1990920191602091820191016105ba565b6001836020036101000a038019825116818451168082178552505050505050905001915050604051809103902060001916141561061b57606081016001610497565b60405160200180807f446f7a656e00000000000000000000000000000000000000000000000000000081525060050190506040516020818303038152906040526040518082805190602001908083835b6020831061068a5780518252601f19909201916020918201910161066b565b51815160209384036101000a60001901801990921691161790526040519190930181900381208a519095508a9450908301928392508401908083835b602083106106e55780518252601f1990920191602091820191016106c6565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040516020818303038152906040526040518082805190602001908083835b602083106107485780518252601f199092019160209182019101610729565b6001836020036101000a038019825116818451168082178552505050505050905001915050604051809103902060001916141561078a57606081016002610497565b600060608201525b6080810184905260a0810183905282840260c082015260e0810182905260068054600181018083556000929092528251805184926007027ff652222313e28459528d920b65115c16c04f3efc82aaedc97be59f3f377c0d3f01916107fb91839160200190610a0b565b5060208281015180516108149260018501920190610a0b565b5060408201516002828101805473ffffffffffffffffffffffffffffffffffffffff191673ffffffffffffffffffffffffffffffffffffffff909316929092178083556060850151929174ff000000000000000000000000000000000000000019909116907401000000000000000000000000000000000000000090849081111561089b57fe5b02179055506080820151816003015560a0820151816004015560c0820151816005015560e082015181600601555050508060c001516005540160058190555050505050505050565b60018054604080516020601f600260001961010087891615020190951694909404938401819004810282018101909252828152606093909290918301828280156102fd5780601f106102d2576101008083540402835291602001916102fd565b60038054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156102fd5780601f106102d2576101008083540402835291602001916102fd565b610100604051908101604052806060815260200160608152602001600073ffffffffffffffffffffffffffffffffffffffff168152602001600060028111156109e957fe5b8152602001600081526020016000815260200160008152602001600081525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610a4c57805160ff1916838001178555610a79565b82800160010185558215610a79579182015b82811115610a79578251825591602001919060010190610a5e565b50610a85929150610a89565b5090565b61030591905b80821115610a855760008155600101610a8f5600a165627a7a72305820640b3bcb878c18aa68e201b3dcde09a82c630a3ff1fff1c5deeddb1aab3004370029";

    public static final String FUNC_GETBUYER = "getBuyer";

    public static final String FUNC_GETCURRENCY = "getCurrency";

    public static final String FUNC_GETCONTRACTTOTALPRICE = "getContractTotalPrice";

    public static final String FUNC_ADDPRODUCT = "addProduct";

    public static final String FUNC_GETSELLER = "getSeller";

    public static final String FUNC_GETTITLE = "getTitle";

    @Deprecated
    protected ProductSaleContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ProductSaleContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ProductSaleContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ProductSaleContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<String> getBuyer() {
        final Function function = new Function(FUNC_GETBUYER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> getCurrency() {
        final Function function = new Function(FUNC_GETCURRENCY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getContractTotalPrice() {
        final Function function = new Function(FUNC_GETCONTRACTTOTALPRICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> addProduct(String name, String description, String unit, BigInteger unitPrice, BigInteger quantityPerUnit, BigInteger expirationDate) {
        final Function function = new Function(
                FUNC_ADDPRODUCT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(description), 
                new org.web3j.abi.datatypes.Utf8String(unit), 
                new org.web3j.abi.datatypes.generated.Int256(unitPrice), 
                new org.web3j.abi.datatypes.generated.Int256(quantityPerUnit), 
                new org.web3j.abi.datatypes.generated.Uint256(expirationDate)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getSeller() {
        final Function function = new Function(FUNC_GETSELLER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getTitle() {
        final Function function = new Function(FUNC_GETTITLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static ProductSaleContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ProductSaleContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ProductSaleContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ProductSaleContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ProductSaleContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ProductSaleContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ProductSaleContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ProductSaleContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ProductSaleContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _seller, String _buyer, String _title, String _currency) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_seller), 
                new org.web3j.abi.datatypes.Utf8String(_buyer), 
                new org.web3j.abi.datatypes.Utf8String(_title), 
                new org.web3j.abi.datatypes.Utf8String(_currency)));
        return deployRemoteCall(ProductSaleContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ProductSaleContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _seller, String _buyer, String _title, String _currency) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_seller), 
                new org.web3j.abi.datatypes.Utf8String(_buyer), 
                new org.web3j.abi.datatypes.Utf8String(_title), 
                new org.web3j.abi.datatypes.Utf8String(_currency)));
        return deployRemoteCall(ProductSaleContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ProductSaleContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _seller, String _buyer, String _title, String _currency) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_seller), 
                new org.web3j.abi.datatypes.Utf8String(_buyer), 
                new org.web3j.abi.datatypes.Utf8String(_title), 
                new org.web3j.abi.datatypes.Utf8String(_currency)));
        return deployRemoteCall(ProductSaleContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ProductSaleContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _seller, String _buyer, String _title, String _currency) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_seller), 
                new org.web3j.abi.datatypes.Utf8String(_buyer), 
                new org.web3j.abi.datatypes.Utf8String(_title), 
                new org.web3j.abi.datatypes.Utf8String(_currency)));
        return deployRemoteCall(ProductSaleContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
