package com.sounds.bvs.data.dao.impl;

import java.util.List;

import com.sounds.bvs.data.dao.AbstractDao;
import com.sounds.bvs.data.dao.ClientsDao;
import com.sounds.bvs.data.entities.Clients;

public class ClientsDaoImpl extends AbstractDao<Clients, Integer>  implements ClientsDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Clients> findAllClients(String queryName) {
		return (List<Clients>)this.getSession().getNamedQuery(queryName).list();
	}

}
