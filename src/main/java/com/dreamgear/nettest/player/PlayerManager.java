package com.dreamgear.nettest.player;

public class PlayerManager {
	PlayerData data;
	
	public PlayerManager(PlayerData data){
		this.data = data;
	}
	
	public PlayerData GetData(){
		return data;
	}
	
}
