select f1.name                                                                     as 'Film1 name',
       s1.start_time                                                               as 'Film1 start time',
       f1.duration                                                                 as 'Film1 duration',
       fs.name                                                                     as 'Film2 name',
       fs.start_time                                                               as 'Film2 start time',
       fs.duration                                                                 as 'Film2 duration',
       timestampdiff(minute, fs.start_time, timestamp(s1.start_time, f1.duration)) as 'Intersection (min)'
from schedule as s1
         join film as f1 on f1.id = s1.film_id
         join (select f2.id,
                      f2.name,
                      s2.start_time,
                      f2.duration
               from schedule as s2
                        join film as f2 on f2.id = s2.film_id
               where date(s2.start_time) = '2021-01-01'
        ) as fs on fs.start_time between s1.start_time and s1.start_time + f1.duration
            and f1.id <> fs.id
where date(s1.start_time) = '2021-01-01'
order by timestampdiff(minute, fs.start_time, timestamp(s1.start_time, f1.duration)) desc;