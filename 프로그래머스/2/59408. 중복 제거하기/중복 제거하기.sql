-- 코드를 입력하세요
SELECT count(*)
from (select distinct name
     from animal_ins) a
where name is not null;