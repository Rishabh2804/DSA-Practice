# Write your MySQL query statement below

# result1
# with MaxRater as (
#     select name as result
#     from Users
#     where user_id = (
#         select user_id 
#         from MovieRating R
#         group by user_id
#         order by count(movie_id) desc
#         limit 1
#     )
#     order by name
# ),
# BestMovie as (
#     select title as result
#     from Movies M inner join MoviesRating R
#     on M.movie_id = R.movie_id    
#     order by title
# )

select results
from (
    select name as results, count(R.user_id) as rating_count
    from Users U join MovieRating R
    on U.user_id = R.user_id
    group by U.user_id
    order by rating_count desc, name
    limit 1
    ) as t1 union all
select results
from (
    select title as results, avg(rating) as avg_rate
    from Movies M join MovieRating R
    on M.movie_id = R.movie_id 
            and created_at between '2020-02-01' and '2020-02-29'
    group by M.title
    order by avg_rate desc, title
    limit 1
    ) as t2