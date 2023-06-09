package com.btmstudio.connection;


import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import com.btmstudio.utils.Credentials;

public class PoolConnection {
	
private final DataSource dataSource;
	
	// Inicializando Pool de Conexiones
    public PoolConnection() {

    	Credentials load = new Credentials();

    	ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();
    	pooledDataSource.setJdbcUrl(load.getUrl());
    	pooledDataSource.setUser(load.getUsername());
    	pooledDataSource.setPassword(load.getPassword());
    	
    	this.dataSource = pooledDataSource;
	}

	public Connection recuperateConnection() {
		
        try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }
}