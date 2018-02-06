package com.dreamgear.nettest.net.request;

import com.dgserver.server.net.BaseMessage;
import com.dgserver.server.net.buffer.MyBuffer;
import com.dreamgear.nettest.net.NetProtocol;

public class TestAReq  extends BaseMessage{
	
    public int testint;
    public long testlong;
    public String teststring;
	
	@Override
	public int GetProtocol() {
		// TODO Auto-generated method stub
		return NetProtocol.TEST_A;
	}
	

	@Override
	public void deserialize(MyBuffer in) {
		// TODO Auto-generated method stub
		super.deserialize(in);
		
		testint = in.getInt();
		testlong = in.getLong();
		teststring = in.getPrefixedString(MyBuffer.STRING_TYPE_SHORT);
		
	}
}
