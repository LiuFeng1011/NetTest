package com.dreamgear.nettest.player;

import java.util.concurrent.ConcurrentHashMap;

public class GamePlayerManager {

	private static GamePlayerManager instance;
	
	public static GamePlayerManager GetInstance(){
		if(instance == null){
			instance = new GamePlayerManager();
		}
		return instance;
	}
	
	private ConcurrentHashMap<Long,PlayerManager> playerMap = new ConcurrentHashMap<Long,PlayerManager>();
	

	public PlayerManager GetPlayerByUid(Long uid){
		return playerMap.get(uid);
	}
	
	public void AddPlayer(PlayerManager pm ){
		synchronized (playerMap) {
			if (!playerMap.containsKey(pm.GetData().uid)) {
				playerMap.put(pm.GetData().uid, pm);
			}
		}
	}
	
	/**
	 * 获取一个玩家 
	 * @param uname
	 * @return
	 */
	public PlayerManager Login(Long uid){
		
		PlayerManager pm = GetPlayerByUid(uid);
		
		//内存中不存在
		if(pm == null){
			//从数据库中获取
			PlayerData pd = GetPlayerDataByDB(uid);//连接数据库获取玩家数据
			
			if(pd == null){
				//数据库中也不存在
				//新玩家
				pd = CreatePlayer(uid);
			}
			pm = new PlayerManager(pd);
		}else{
			return pm;
		}
		
		AddPlayer(pm);
		
		return pm;
	}
	
	/**
	 * 创建玩家
	 * @param uname
	 * @return
	 */
	public PlayerData CreatePlayer(Long uid) {

		PlayerData data = new PlayerData();
		data.setUid(uid);
		
		//这里存储到把新玩家存储到数据库中
		
		return data;
	}
	
	
	//从数据库获取玩家数据，这里只是测试，所以直接新建了一个
	public PlayerData GetPlayerDataByDB(long uid){
		PlayerData ret = new PlayerData();
		ret.uid = uid;
		return ret;
	}
	
}
