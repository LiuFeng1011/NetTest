package com.dreamgear.nettest.net.response;

import com.dgserver.server.net.BaseMessage;
import com.dgserver.server.net.buffer.MyBuffer;
import com.dreamgear.nettest.net.NetProtocol;

public class TestBResp  extends BaseMessage{
	@Override
	public int GetProtocol() {
		// TODO Auto-generated method stub
		return NetProtocol.TEST_B;
	}
	
	@Override
	public void serialize(MyBuffer buf){
    	super.serialize(buf);
	}
}
