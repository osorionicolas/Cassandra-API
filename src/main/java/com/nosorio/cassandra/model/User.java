package com.nosorio.cassandra.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class User {
    @PrimaryKeyColumn(
      name = "id", 
      ordinal = 2, 
      type = PrimaryKeyType.CLUSTERED, 
      ordering = Ordering.DESCENDING)
    private UUID id;
    
    @PrimaryKeyColumn(
      name = "firstName", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String firstName;
   
    @PrimaryKeyColumn(
      name = "lastName", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String lastName;
    
    @Column
    private Set<String> tags = new HashSet<>();
    
    public User(UUID id, String firstName, String lastName, Set<String> tags) {
    	this.id = id;
    	this.firstName = firstName;
    	this.lastName = lastName;
        this.tags.addAll(tags);
    }
   
    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public void setTags(final Set<String> tags) {
        this.tags = tags;
    }
}