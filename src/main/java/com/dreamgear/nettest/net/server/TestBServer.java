package com.dreamgear.nettest.net.server;

import org.apache.mina.core.session.IoSession;

import com.dgserver.server.net.BaseMessage;
import com.dgserver.server.net.BaseServer;
import com.dreamgear.nettest.net.NetProtocol;
import com.dreamgear.nettest.net.request.TestAReq;
import com.dreamgear.nettest.net.request.TestBReq;
import com.dreamgear.nettest.net.response.TestBResp;

public class TestBServer implements BaseServer  {
	public int GetProtocol() {
		// TODO Auto-generated method stub
		return NetProtocol.TEST_B;
	}

	public BaseMessage GetRequest() {
		// TODO Auto-generated method stub
		return new TestBReq();
	}

	public BaseMessage handle(IoSession is,BaseMessage request) {

		System.out.print("TestBServer receive msg");
		TestBResp resp = new TestBResp();
		
		return resp;
	}
}
