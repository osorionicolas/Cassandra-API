package com.nosorio.cassandra.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.nosorio.cassandra.model.User;

@Repository
public interface UserRepository extends CassandraRepository<User, UUID> {

}
