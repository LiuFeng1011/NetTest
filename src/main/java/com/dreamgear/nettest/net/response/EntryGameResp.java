package com.dreamgear.nettest.net.response;

import com.dgserver.server.net.BaseMessage;
import com.dgserver.server.net.buffer.MyBuffer;
import com.dreamgear.nettest.net.NetProtocol;


public class EntryGameResp extends BaseMessage{
	@Override
	public int GetProtocol() {
		// TODO Auto-generated method stub
		return NetProtocol.ENTRY_GAME;
	}
	@Override
	public void serialize(MyBuffer in){
    	super.serialize(in);
    }
}
