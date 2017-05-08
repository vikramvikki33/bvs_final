package com.sounds.bvs.data.dao;

import java.util.List;

import com.sounds.bvs.data.entities.Clients;

/**
 * @author Vikram
 *
 */
public interface ClientsDao extends Dao<Clients, Integer>{

	public List<Clients> findAllClients(String queryName);

}
