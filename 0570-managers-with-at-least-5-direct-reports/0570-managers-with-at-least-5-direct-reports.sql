# Write your MySQL query statement below
with ManagerId as (
    select managerId 
    from Employee 
    group by managerId 
    having count(managerId) >= 5
)
select name
from Employee E
    inner join ManagerId M on E.id = M.managerId