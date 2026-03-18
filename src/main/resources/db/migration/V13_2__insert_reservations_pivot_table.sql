INSERT INTO `reservations` (`user_id`, `representation_id`)
SELECT u.id, r.id
FROM users u
JOIN representations r
WHERE u.id = (SELECT MIN(id) FROM users)
  AND r.id = (SELECT MIN(id) FROM representations);
