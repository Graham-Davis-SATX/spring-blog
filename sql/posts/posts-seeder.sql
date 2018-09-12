CREATE DATABASE IF NOT EXISTS v_blog_db;
USE v_blog_db;

INSERT INTO user (username, email, password)
    VALUES
      ('timtaylor', 'thetoolman@tools.com', 'tools');

INSERT INTO posts (body, title, user_id)
    VALUES
      ('this is some body', 'this is a title', 1)

