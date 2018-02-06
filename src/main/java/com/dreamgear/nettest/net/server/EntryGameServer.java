package com.dreamgear.nettest.net.server;

import org.apache.mina.core.session.IoSession;

import com.dgserver.server.net.BaseMessage;
import com.dgserver.server.net.BaseServer;
import com.dreamgear.nettest.net.NetProtocol;
import com.dreamgear.nettest.net.request.EntryGameReq;
import com.dreamgear.nettest.net.request.TestAReq;
import com.dreamgear.nettest.net.response.EntryGameResp;
import com.dreamgear.nettest.net.response.TestAResp;

public class EntryGameServer implements BaseServer {
	public int GetProtocol() {
		// TODO Auto-generated method stub
		return NetProtocol.ENTRY_GAME;
	}

	public BaseMessage GetRequest() {
		// TODO Auto-generated method stub
		return new EntryGameReq();
	}

	public BaseMessage handle(IoSession is,BaseMessage request) {
		System.out.println("EntryGameServer");
		EntryGameResp resp = new EntryGameResp();
		
		return resp;
	}
}
