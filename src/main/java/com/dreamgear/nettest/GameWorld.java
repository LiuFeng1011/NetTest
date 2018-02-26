package com.dreamgear.nettest;

import java.util.HashMap;
import java.util.Map;

import com.dgserver.server.net.BaseServer;
import com.dgserver.server.net.ServerManager;
import com.dreamgear.http.HttpServer;
import com.dreamgear.nettest.net.NetProtocol;
import com.dreamgear.nettest.net.server.EntryGameServer;
import com.dreamgear.nettest.net.server.TestAServer;
import com.dreamgear.nettest.net.server.TestBServer;

public class GameWorld {
	private static GameWorld instance;

	public static GameWorld GetInstance(){
		if(instance == null){
			instance = new GameWorld();
		}
		return instance;
	}

	private ServerManager server;
	
	final int port = 9999;

	public void StartGame(){

		try{
			//网络服务 端口号
			server = new ServerManager(port);
			server.Start();
			
			//开启http监听
			HttpServer.getInstance().run(); 
			
			//注册游戏业务服务
			server.setServerList(RegistServer());
			
			//启动游戏
			Start();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void Start(){
		new MainLoop().start();
	}
	
	/**
	 * 游戏主线程
	 * 
	 */
	public class MainLoop extends Thread {
		@Override
		public void run() {
			System.out.println("MAIN LOOP THREAD START!");
			while (true) {
				try {
					// 游戏逻辑
					GameTick();
				} catch (Exception e) {
					System.out.println("error in MainLoop tick ");
					e.printStackTrace();
				}
			}
		}

		/**
		 * 游戏逻辑
		 */
		public void GameTick() {
			
		}
	}
	
	Map<Integer,BaseServer> RegistServer(){

		Map<Integer,BaseServer> servermap = new HashMap<Integer,BaseServer>();

		servermap.put(NetProtocol.ENTRY_GAME, new EntryGameServer());
		servermap.put(NetProtocol.TEST_A, new TestAServer());
		servermap.put(NetProtocol.TEST_B, new TestBServer());

		return servermap;
	}
}
