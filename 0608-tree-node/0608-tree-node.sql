# Write your MySQL query statement below
SELECT DISTINCT T.id,
    CASE
        WHEN T.p_id IS NULL THEN 'Root'
        WHEN C.p_id IS NULL THEN 'Leaf'
        ELSE 'Inner'
    END AS type
FROM Tree T
LEFT JOIN Tree C ON T.id = C.p_id
