# Write your MySQL query statement below
-- | sender_id | send_to_id |request_date|
-- | requester_id | accepter_id |accept_date |

select round(
    ifnull(
        (select count(*) from (
            select distinct requester_id, accepter_id from request_accepted
        ) as A) /
        (select count(*) from (
            select distinct sender_id, send_to_id from friend_request
        ) as B), 0)
    , 2) as accept_rate;