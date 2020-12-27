# перерывы более 30 минут
select f1.name                                                                     as 'Film1 name',
       s1.start_time                                                               as 'Film1 start time',
       f1.duration                                                                 as 'Film1 duration',
       fs.name                                                                     as 'Film2 name',
       fs.start_time                                                               as 'Film2 start time',
       timestampdiff(minute, timestamp(s1.start_time, f1.duration), fs.start_time) as 'Idling (min)'
from schedule as s1
         join film as f1 on f1.id = s1.film_id
         join (select f2.id,
                      f2.name,
                      s2.start_time,
                      f2.duration
               from schedule as s2
                        join film as f2 on f2.id = s2.film_id
               where date(s2.start_time) = '2021-01-01'
               order by s2.start_time
        ) as fs on fs.start_time =
           (select s3.start_time
            from schedule as s3
            where date(s3.start_time) = '2021-01-01'
              and s3.start_time > s1.start_time
              and timestampdiff(minute, timestamp(s1.start_time, f1.duration), fs.start_time) > 30
            order by s3.start_time
            limit 1
           )
order by timestampdiff(minute, timestamp(s1.start_time, f1.duration), fs.start_time) desc;