# Write your MySQL query statement below

with TopUser as (
    select name as results, count(R.user_id) as rating_count
    from Users U join MovieRating R
    on U.user_id = R.user_id
    group by U.user_id
    order by rating_count desc, name
    limit 1
),
TopMovie as (
    select title as results, avg(rating) as avg_rate
    from Movies M join MovieRating R
    on M.movie_id = R.movie_id 
            and created_at between '2020-02-01' and '2020-02-29'
    group by M.title
    order by avg_rate desc, title
    limit 1
)
select results
from TopUser 
    union all
select results
from TopMovie