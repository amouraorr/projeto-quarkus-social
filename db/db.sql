CREATE TABLE quarkus-social;

CREATE TABLE IF NOT EXISTS quarkus_social.USERS (
         id BIGSERIAL NOT NULL PRIMARY KEY,
         name VARCHAR(100) NOT NULL,
         age INTEGER NOT NULL
);

 CREATE TABLE IF NOT EXISTS quarkus_social.POSTS (
     id BIGSERIAL NOT NULL PRIMARY KEY,
     post_text VARCHAR(150) NOT NULL,
     dateTime TIMESTAMP NOT NULL,
     user_id BIGINT NOT NULL REFERENCES quarkus_social.users(id)
 );

  CREATE TABLE IF NOT EXISTS quarkus_social.FOLLOWERS (
      id BIGSERIAL NOT NULL PRIMARY KEY,
      user_id BIGINT NOT NULL REFERENCES quarkus_social.USERS(id),
      followers_id BIGINT NOT NULL REFERENCES quarkus_social.USERS(id)
  );