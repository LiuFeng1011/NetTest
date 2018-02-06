package com.dreamgear.nettest;

import com.dgserver.server.app.Plugin;
import com.dgserver.server.app.ServerApp;
import com.dgserver.server.net.DGServerCallBack;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	final ServerApp app = ServerApp.getInstance();
    	System.out.println("=======main=============");
    	app.registPlugin(new Plugin()
        {
			public void onAppStart() throws Exception {
				// TODO Auto-generated method stub

		        System.out.println("-----------service start------------");
			}
			

			public void onAppStop() throws Exception {
				// TODO Auto-generated method stub
		        System.out.println("-----------service stop-----------");
			}
        });
    	
    	app.start();
    	
    	app.SetUserOfflineCallBack(
    			new DGServerCallBack(){

					public void ServerCallBack(Object obj) {
						// TODO Auto-generated method stub
						long uid = Long.parseLong(obj.toString());
						System.out.println("OfflineCallBack : " + uid);
					}
    				
    			}
    		);

    	GameWorld.GetInstance().StartGame();
    }
}
