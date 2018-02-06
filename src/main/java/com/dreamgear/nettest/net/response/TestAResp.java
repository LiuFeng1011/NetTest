package com.dreamgear.nettest.net.response;

import com.dgserver.server.net.BaseMessage;
import com.dgserver.server.net.buffer.MyBuffer;
import com.dreamgear.nettest.net.NetProtocol;

public class TestAResp  extends BaseMessage{
	

    public int testint;
    public long testlong;
    public String teststring;
	
	
    public TestAResp(int testint,long testlong,String teststring){
        this.testint = testint;
        this.testlong = testlong;
        this.teststring = teststring;
    }
    
	@Override
	public int GetProtocol() {
		// TODO Auto-generated method stub
		return NetProtocol.TEST_A;
	}
	
	@Override
	public void serialize(MyBuffer buf){
    	super.serialize(buf);
    	
    	buf.putInt(testint);
    	buf.putLong(testlong);
    	buf.putPrefixedString(teststring,MyBuffer.STRING_TYPE_SHORT);
	}
}
