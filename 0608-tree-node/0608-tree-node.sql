# Write your MySQL query statement below
with ChildNodes as(
    select count(p_id) as children, p_id 
    from Tree
    group by p_id
    order by p_id
)
select id, 
    case when T.p_id is null then "Root"
         when C.children is null then "Leaf"
         else "Inner"
    end as type
from ChildNodes C right join Tree T
on C.p_id = T.id
