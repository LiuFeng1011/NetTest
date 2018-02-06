package com.dreamgear.nettest.net.server;

import org.apache.mina.core.session.IoSession;

import com.dgserver.server.net.BaseMessage;
import com.dgserver.server.net.BaseServer;
import com.dreamgear.nettest.net.NetProtocol;
import com.dreamgear.nettest.net.request.TestAReq;
import com.dreamgear.nettest.net.response.TestAResp;

public class TestAServer implements BaseServer {

	public int GetProtocol() {
		// TODO Auto-generated method stub
		return NetProtocol.TEST_A;
	}

	public BaseMessage GetRequest() {
		// TODO Auto-generated method stub
		return new TestAReq();
	}

	public BaseMessage handle(IoSession is,BaseMessage request) {
		System.out.print("TestAServer receive msg");
		
		TestAReq req = (TestAReq)request;
		System.out.println("req int : " + req.testint);
		System.out.println("req long : " + req.testlong);
		System.out.println("req string : " + req.teststring);
		
		TestAResp resp = new TestAResp(req.testint+1,req.testlong+1,req.teststring+"abc");
		
		return resp;
	}
}
