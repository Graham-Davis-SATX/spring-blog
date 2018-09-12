CREATE DATABASE IF NOT EXISTS v_blog_db;
USE v_blog_db;

INSERT INTO ads (description, title)
  VALUES
    ('this is used', 'ps4'),
    ('this is not used', 'xbox360'),
    ('i don\'t remember buying this damn thing', 'switch');