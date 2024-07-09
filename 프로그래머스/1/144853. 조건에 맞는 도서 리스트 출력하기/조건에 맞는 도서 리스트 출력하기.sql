-- 코드를 입력하세요
# select * from book;
SELECT BOOK_ID, date_format(published_date, '%Y-%m-%d') as PUBLISHED_DATE
from book
where category = "인문" and published_date like "2021%"
order by published_date asc;