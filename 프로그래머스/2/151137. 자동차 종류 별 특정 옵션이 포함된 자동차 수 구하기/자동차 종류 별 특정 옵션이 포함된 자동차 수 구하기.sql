-- 코드를 입력하세요
# SELECT * from car_rental_company_car;
select CAR_TYPE, count(*) as CARS
from car_rental_company_car
where (options like "%가죽시트%") or (options like "%열선시트%") or (options like "%통풍시트%")
group by car_type
order by car_type;