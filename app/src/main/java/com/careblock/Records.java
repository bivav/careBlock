package com.careblock;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.2.0.
 */
public class Records extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b50604051610a25380380610a258339810180604052606081101561003357600080fd5b81019080805164010000000081111561004b57600080fd5b8281019050602081018481111561006157600080fd5b815185600182028301116401000000008211171561007e57600080fd5b5050929190602001805164010000000081111561009a57600080fd5b828101905060208101848111156100b057600080fd5b81518560018202830111640100000000821117156100cd57600080fd5b5050929190602001805190602001909291905050506100fc838383610104640100000000026401000000009004565b505050610308565b60016000815480929190600101919050555060a0604051908101604052806001548152602001828152602001848152602001602060405190810160405280600081525081526020016002846040518082805190602001908083835b602083101515610184578051825260208201915060208101905060208303925061015f565b6001836020036101000a038019825116818451168082178552505050505050905001915050602060405180830381855afa1580156101c6573d6000803e3d6000fd5b5050506040513d60208110156101db57600080fd5b8101908080519060200190929190505050815250600080600154815260200190815260200160002060008201518160000155602082015181600101556040820151816002019080519060200190610233929190610263565b506060820151816003019080519060200190610250929190610263565b5060808201518160040155905050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106102a457805160ff19168380011785556102d2565b828001600101855582156102d2579182015b828111156102d15782518255916020019190600101906102b6565b5b5090506102df91906102e3565b5090565b61030591905b808211156103015760008160009055506001016102e9565b5090565b90565b61070e806103176000396000f3fe608060405260043610610062576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806303e9e6091461006757806324a3a2471461011b578063a1982835146101f7578063d919b11d1461032c575b600080fd5b34801561007357600080fd5b506100a06004803603602081101561008a57600080fd5b8101908080359060200190929190505050610357565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156100e05780820151818401526020810190506100c5565b50505050905090810190601f16801561010d5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561012757600080fd5b506101f56004803603606081101561013e57600080fd5b81019080803590602001909291908035906020019064010000000081111561016557600080fd5b82018360208201111561017757600080fd5b8035906020019184600183028401116401000000008311171561019957600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192908035906020019092919050505061045b565b005b34801561020357600080fd5b506102306004803603602081101561021a57600080fd5b81019080803590602001909291905050506104d1565b604051808681526020018581526020018060200180602001848152602001838103835286818151815260200191508051906020019080838360005b8381101561028657808201518184015260208101905061026b565b50505050905090810190601f1680156102b35780820380516001836020036101000a031916815260200191505b50838103825285818151815260200191508051906020019080838360005b838110156102ec5780820151818401526020810190506102d1565b50505050905090810190601f1680156103195780820380516001836020036101000a031916815260200191505b5097505050505050505060405180910390f35b34801561033857600080fd5b50610341610637565b6040518082815260200191505060405180910390f35b60606000600190505b6001548111151561045457828114156104475782600080838152602001908152602001600020600001541415610446576000808281526020019081526020016000206003018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156104395780601f1061040e57610100808354040283529160200191610439565b820191906000526020600020905b81548152906001019060200180831161041c57829003601f168201915b5050505050915050610456565b5b8080600101915050610360565b505b919050565b6000600190505b600154811115156104cb57838114156104be57816000808381526020019081526020016000206004015414156104bd578260008083815260200190815260200160002060030190805190602001906104bb92919061063d565b505b5b8080600101915050610462565b50505050565b6000602052806000526040600020600091509050806000015490806001015490806002018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105895780601f1061055e57610100808354040283529160200191610589565b820191906000526020600020905b81548152906001019060200180831161056c57829003601f168201915b505050505090806003018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156106275780601f106105fc57610100808354040283529160200191610627565b820191906000526020600020905b81548152906001019060200180831161060a57829003601f168201915b5050505050908060040154905085565b60015481565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061067e57805160ff19168380011785556106ac565b828001600101855582156106ac579182015b828111156106ab578251825591602001919060010190610690565b5b5090506106b991906106bd565b5090565b6106df91905b808211156106db5760008160009055506001016106c3565b5090565b9056fea165627a7a72305820c4e9b214f35839edc969770a22ecee3ed3cff96556b0d3f5b81dd19165f535060029";

    public static final String FUNC_PATIENTS = "Patients";

    public static final String FUNC_PATIENT_COUNT = "Patient_count";

    public static final String FUNC_ADDRECORD = "addRecord";

    public static final String FUNC_GETRECORD = "getRecord";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("5777", "0x636b2aF21C0e4d22F32b651a0A65e9fD4cAC6Fa6");
    }

    @Deprecated
    protected Records(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    protected Records(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<Tuple5<BigInteger, BigInteger, String, String, byte[]>> Patients(BigInteger param0) {
        final Function function = new Function(FUNC_PATIENTS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {},
                        new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>() {}));
        return new RemoteCall<Tuple5<BigInteger, BigInteger, String, String, byte[]>>(
                new Callable<Tuple5<BigInteger, BigInteger, String, String, byte[]>>() {
                    @Override
                    public Tuple5<BigInteger, BigInteger, String, String, byte[]> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);

                        return new Tuple5<BigInteger, BigInteger, String, String, byte[]>(
                                (BigInteger) results.get(0).getValue(),
                                (BigInteger) results.get(1).getValue(),
                                (String) results.get(2).getValue(),
                                (String) results.get(3).getValue(),
                                (byte[]) results.get(4).getValue());
                    }
                });
    }

    public RemoteCall<BigInteger> Patient_count() {
        final Function function = new Function(FUNC_PATIENT_COUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> addRecord(BigInteger pid, String _record, byte[] _sha_password) {
        final Function function = new Function(
                FUNC_ADDRECORD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(pid), 
                new org.web3j.abi.datatypes.Utf8String(_record), 
                new org.web3j.abi.datatypes.generated.Bytes32(_sha_password)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getRecord(BigInteger pid) {
        final Function function = new Function(
                FUNC_GETRECORD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(pid)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Records load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Records(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Records load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Records(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }


    @Deprecated
    public static RemoteCall<Records> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _name, byte[] _key, BigInteger did) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.DynamicBytes(_key), 
                new org.web3j.abi.datatypes.generated.Uint256(did)));
        return deployRemoteCall(Records.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Records> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _name, byte[] _key, BigInteger did) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.DynamicBytes(_key), 
                new org.web3j.abi.datatypes.generated.Uint256(did)));
        return deployRemoteCall(Records.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
