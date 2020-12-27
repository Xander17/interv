select (if(f.id is null, 'Total', f.name)) as 'Film name',
       count(t.id)                         as 'Audience',
       count(t.id) / count(distinct s.id)  as 'Average audience',
       sum(pc.price)                       as 'Total gross'
from film as f
         join schedule as s on f.id = s.film_id
         join price_category as pc on pc.id = s.price_category_id
         join ticket as t on s.id = t.schedule_id
group by f.id
with rollup
order by grouping (f.id), sum(pc.price) desc