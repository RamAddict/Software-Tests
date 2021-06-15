package br.ufsc.solidity.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
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
 * <p>Generated with web3j version 4.6.4.
 */
@SuppressWarnings("rawtypes")
public class PaperContract extends Contract {
    public static final String BINARY = "6080604052600b805462ffffff191690553480156200001d57600080fd5b5060405162000ceb38038062000ceb833981810160405260408110156200004357600080fd5b81019080805160405193929190846401000000008211156200006457600080fd5b9083019060208201858111156200007a57600080fd5b82516401000000008111828201881017156200009557600080fd5b82525081516020918201929091019080838360005b83811015620000c4578181015183820152602001620000aa565b50505050905090810190601f168015620000f25780820380516001836020036101000a031916815260200191505b50604052602001805160405193929190846401000000008211156200011657600080fd5b9083019060208201858111156200012c57600080fd5b82516401000000008111828201881017156200014757600080fd5b82525081516020918201929091019080838360005b83811015620001765781810151838201526020016200015c565b50505050905090810190601f168015620001a45780820380516001836020036101000a031916815260200191505b5060405250508251620001c091506000906020850190620001fd565b508051620001d6906001906020840190620001fd565b5050600060038190556005805460ff1916905560078190556009819055600a5550620002a2565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200024057805160ff191683800117855562000270565b8280016001018555821562000270579182015b828111156200027057825182559160200191906001019062000253565b506200027e92915062000282565b5090565b6200029f91905b808211156200027e576000815560010162000289565b90565b610a3980620002b26000396000f3fe608060405234801561001057600080fd5b506004361061014d5760003560e01c80636355ab56116100c35780639481da531161007c5780639481da531461030a578063ca7a82bd14610312578063e06ab1e41461031a578063e4173b2c14610322578063e4a302c014610451578063fa0c1513146104f75761014d565b80636355ab561461029c578063765f744c146102a45780637d8730d6146102c05780637faf6b16146102dd5780638bf0f91b146102fa5780638d56bd94146103025761014d565b80632ba15cf3116101155780632ba15cf3146101975780632bf9e7101461019f57806347089f09146101bc5780634e69d560146101d65780635789c7d014610202578063603daf9a1461021f5761014d565b80630177b556146101525780630397fe3e1461015c5780630eedb04c146101645780630f15f4c01461016c5780630f64601714610174575b600080fd5b61015a6104ff565b005b61015a61055d565b61015a61056c565b61015a6105cf565b61015a6004803603604081101561018a57600080fd5b50803590602001356105e2565b61015a6105fb565b61015a600480360360208110156101b557600080fd5b503561060e565b6101c4610613565b60408051918252519081900360200190f35b6101de610650565b604051808260038111156101ee57fe5b60ff16815260200191505060405180910390f35b61015a6004803603602081101561021857600080fd5b5035610659565b610227610666565b6040805160208082528351818301528351919283929083019185019080838360005b83811015610261578181015183820152602001610249565b50505050905090810190601f16801561028e5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6101c46106fb565b6102ac610701565b604080519115158252519081900360200190f35b61015a600480360360208110156102d657600080fd5b503561070f565b61015a600480360360208110156102f357600080fd5b5035610714565b610227610719565b6101c46107d0565b6101c46107d6565b61015a6107dc565b61015a6107f0565b61015a6004803603606081101561033857600080fd5b81019060208101813564010000000081111561035357600080fd5b82018360208201111561036557600080fd5b8035906020019184600183028401116401000000008311171561038757600080fd5b91908080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525092959493602081019350359150506401000000008111156103da57600080fd5b8201836020820111156103ec57600080fd5b8035906020019184600183028401116401000000008311171561040e57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295505091359250610801915050565b61015a6004803603602081101561046757600080fd5b81019060208101813564010000000081111561048257600080fd5b82018360208201111561049457600080fd5b803590602001918460018302840111640100000000831117156104b657600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610896945050505050565b6102276108a9565b600854600754141561055b5760045460001981019015610559576004818154811061052657fe5b600091825260208220600390910201906105408282610907565b61054e600183016000610907565b600282016000905550505b505b565b600b805460ff19166001179055565b6005805460ff19166003179055600b5460ff61010090910416801561059a5750600b5462010000900460ff16155b1561055b57600854601e01600a541161055b576008546009541161055b57600580546002919060ff19166001835b0217905550565b600580546001919060ff191682806105c8565b60026008540382116105f75760088054820190555b5050565b600b805462ff0000191662010000179055565b600955565b600454600090610626575060001961064d565b60048054600019810190811061063857fe5b90600052602060002090600302016002015490505b90565b60055460ff1690565b6007819055600a01600855565b60018054604080516020601f600260001961010087891615020190951694909404938401819004810282018101909252828152606093909290918301828280156106f15780601f106106c6576101008083540402835291602001916106f1565b820191906000526020600020905b8154815290600101906020018083116106d457829003601f168201915b5050505050905090565b60045490565b600b54610100900460ff1690565b600a55565b600655565b60045460609061074457506040805180820190915260048152636572726f60e01b602082015261064d565b60048054600019810190811061075657fe5b90600052602060002090600302016001018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156106f15780601f106106c6576101008083540402835291602001916106f1565b60065490565b60035490565b600580546003919060ff19166001836105c8565b600b805461ff001916610100179055565b61080961094b565b8381526020808201849052604082018390526004805460018101808355600092909252835180519293859360039093027f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b0192610869928492019061096c565b506020828101518051610882926001850192019061096c565b506040820151816002015550505050505050565b80516105f790600290602084019061096c565b60028054604080516020601f60001961010060018716150201909416859004938401819004810282018101909252828152606093909290918301828280156106f15780601f106106c6576101008083540402835291602001916106f1565b50805460018160011615610100020316600290046000825580601f1061092d5750610559565b601f01602090049060005260206000209081019061055991906109ea565b60405180606001604052806060815260200160608152602001600081525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106109ad57805160ff19168380011785556109da565b828001600101855582156109da579182015b828111156109da5782518255916020019190600101906109bf565b506109e69291506109ea565b5090565b61064d91905b808211156109e657600081556001016109f056fea265627a7a723158200efdea040de320e1d39b3bcdadd0b32634abffe06994780a9f75ae7eba780eee64736f6c63430005110032";

    public static final String FUNC_ACTIVATE = "activate";

    public static final String FUNC_ADDPRODUCT = "addProduct";

    public static final String FUNC_FRIENDLYTERMINATION = "friendlyTermination";

    public static final String FUNC_FULFILLDELIVERY = "fulfillDelivery";

    public static final String FUNC_GETBUYER = "getBuyer";

    public static final String FUNC_GETBUYERADDRESS = "getBuyerAddress";

    public static final String FUNC_GETCONTRACTTOTALPRICE = "getContractTotalPrice";

    public static final String FUNC_GETEFFECTIVEDAY = "getEffectiveDay";

    public static final String FUNC_GETPRODUCTGROUP = "getProductGroup";

    public static final String FUNC_GETPRODUCTQUANTITY = "getProductQuantity";

    public static final String FUNC_GETPRODUCTSSIZE = "getProductsSize";

    public static final String FUNC_GETSTATUS = "getStatus";

    public static final String FUNC_ISDELIVERED = "isDelivered";

    public static final String FUNC_NOTIFIESDELAY = "notifiesDelay";

    public static final String FUNC_REMOVEPRODUCT = "removeProduct";

    public static final String FUNC_SETBUYERADDRESS = "setBuyerAddress";

    public static final String FUNC_SETDELIVERDAY = "setDeliverDay";

    public static final String FUNC_SETEFFECTIVEDAY = "setEffectiveDay";

    public static final String FUNC_SETFINE = "setFine";

    public static final String FUNC_SETPAYMENTDAY = "setPaymentDay";

    public static final String FUNC_SETSOLICITATIONDAY = "setSolicitationDay";

    public static final String FUNC_UNSUCCESSFULTERMINATE = "unsuccessfulTerminate";

    public static final String FUNC_VERIFYCONTRACTTERMINATION = "verifyContractTermination";

    @Deprecated
    protected PaperContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PaperContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected PaperContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected PaperContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> activate() {
        final Function function = new Function(
                FUNC_ACTIVATE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addProduct(String name, String group, BigInteger quantity) {
        final Function function = new Function(
                FUNC_ADDPRODUCT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(group), 
                new org.web3j.abi.datatypes.generated.Int256(quantity)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> friendlyTermination() {
        final Function function = new Function(
                FUNC_FRIENDLYTERMINATION, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> fulfillDelivery() {
        final Function function = new Function(
                FUNC_FULFILLDELIVERY, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getBuyer() {
        final Function function = new Function(FUNC_GETBUYER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> getBuyerAddress() {
        final Function function = new Function(FUNC_GETBUYERADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getContractTotalPrice() {
        final Function function = new Function(FUNC_GETCONTRACTTOTALPRICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getEffectiveDay() {
        final Function function = new Function(FUNC_GETEFFECTIVEDAY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getProductGroup() {
        final Function function = new Function(FUNC_GETPRODUCTGROUP, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getProductQuantity() {
        final Function function = new Function(FUNC_GETPRODUCTQUANTITY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getProductsSize() {
        final Function function = new Function(FUNC_GETPRODUCTSSIZE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getStatus() {
        final Function function = new Function(FUNC_GETSTATUS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> isDelivered() {
        final Function function = new Function(FUNC_ISDELIVERED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> notifiesDelay(BigInteger notificationDay, BigInteger delay) {
        final Function function = new Function(
                FUNC_NOTIFIESDELAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(notificationDay), 
                new org.web3j.abi.datatypes.generated.Uint256(delay)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> removeProduct() {
        final Function function = new Function(
                FUNC_REMOVEPRODUCT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setBuyerAddress(String _buyerAddress) {
        final Function function = new Function(
                FUNC_SETBUYERADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_buyerAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setDeliverDay(BigInteger day) {
        final Function function = new Function(
                FUNC_SETDELIVERDAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(day)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setEffectiveDay(BigInteger _effectiveDay) {
        final Function function = new Function(
                FUNC_SETEFFECTIVEDAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_effectiveDay)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setFine() {
        final Function function = new Function(
                FUNC_SETFINE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setPaymentDay(BigInteger p) {
        final Function function = new Function(
                FUNC_SETPAYMENTDAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(p)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setSolicitationDay(BigInteger _solicitationDay) {
        final Function function = new Function(
                FUNC_SETSOLICITATIONDAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_solicitationDay)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> unsuccessfulTerminate() {
        final Function function = new Function(
                FUNC_UNSUCCESSFULTERMINATE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> verifyContractTermination() {
        final Function function = new Function(
                FUNC_VERIFYCONTRACTTERMINATION, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static PaperContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new PaperContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static PaperContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PaperContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static PaperContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new PaperContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PaperContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new PaperContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<PaperContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _seller, String _buyer) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_seller), 
                new org.web3j.abi.datatypes.Utf8String(_buyer)));
        return deployRemoteCall(PaperContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<PaperContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _seller, String _buyer) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_seller), 
                new org.web3j.abi.datatypes.Utf8String(_buyer)));
        return deployRemoteCall(PaperContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<PaperContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _seller, String _buyer) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_seller), 
                new org.web3j.abi.datatypes.Utf8String(_buyer)));
        return deployRemoteCall(PaperContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<PaperContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _seller, String _buyer) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_seller), 
                new org.web3j.abi.datatypes.Utf8String(_buyer)));
        return deployRemoteCall(PaperContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
