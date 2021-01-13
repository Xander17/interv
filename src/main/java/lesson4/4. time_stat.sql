# статистика по ценовым категориям
select pc.name       as 'Price category',
       count(t.id)   as 'Audience',
       sum(pc.price) as 'Total gross'
from price_category as pc
         join schedule as s on pc.id = s.price_category_id
         join ticket as t on s.id = t.schedule_id
group by pc.id