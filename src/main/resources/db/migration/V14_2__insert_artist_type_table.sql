INSERT INTO `artist_type` (`artist_id`, `type_id`)
SELECT a.id, t.id
FROM artists a
JOIN types t
WHERE (a.id = 1 AND t.id = 1)
   OR (a.id = 1 AND t.id = 3)
   OR (a.id = 2 AND t.id = 3);
