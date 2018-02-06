package com.dreamgear.nettest.net.request;

import com.dgserver.server.net.BaseMessage;
import com.dgserver.server.net.buffer.MyBuffer;
import com.dreamgear.nettest.net.NetProtocol;

public class EntryGameReq extends BaseMessage {
	@Override
	public int GetProtocol() {
		// TODO Auto-generated method stub
		return NetProtocol.ENTRY_GAME;
	}
	
	@Override
	public void deserialize(MyBuffer in) {
		// TODO Auto-generated method stub
		super.deserialize(in);
	}
}
