# Write your MySQL query statement below

# with SortedSalaries as (
#     select distinct salary 
#     from Employee
#     order by salary desc
#     limit 2
# )

select distinct (
    select distinct salary 
    from Employee
    order by salary desc
    limit 1
    offset 1
) as SecondHighestSalary
