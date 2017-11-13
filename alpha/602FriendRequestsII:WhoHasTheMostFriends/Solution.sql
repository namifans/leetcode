# Write your MySQL query statement below
-- | requester_id | accepter_id | accept_date|

select ids as id, count(*) as num
from 
(
    select requester_id as ids from request_accepted
    union all
    select accepter_id from request_accepted
) as tb1
group by id
order by num desc
limit 1;