FROM cassandra

COPY entrypoint.sh /entrypoint.sh
ENV CASSANDRA_KEYSPACE=testkeyspace
ENTRYPOINT ["/entrypoint.sh"]
CMD ["cassandra", "-f"]