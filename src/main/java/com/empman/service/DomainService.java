package com.empman.service;

import com.empman.entity.Domain;

public interface DomainService {
	void createDomain(Domain domain);
	void deleteDomain(Domain domain);
	void updateDomain(Domain domain);
	void getDomain(int id);
	Domain getDomainD(int id);
	void getDomains();
}
