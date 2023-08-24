# Write your MySQL query statement below

with TopUser as (
    select U.name as results,
        row_number() over (order by count(R.user_id) desc, U.name) as rn    
    from Users U join MovieRating R
    on U.user_id = R.user_id
    group by U.user_id
),
TopMovie as (
    select title as results,
        Row_Number() over (order by avg(rating) desc, M.title) as rn    
    from Movies M join MovieRating R
    on M.movie_id = R.movie_id 
    where created_at between '2020-02-01' and '2020-02-29'
    group by M.title
)
select results
from TopUser where rn = 1
    union all
select results
from TopMovie where rn = 1

