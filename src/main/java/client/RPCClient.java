package client;

import commom.RPCRequest;
import commom.RPCResponse;

public interface RPCClient {
    RPCResponse sendRequest(RPCRequest response);
}
