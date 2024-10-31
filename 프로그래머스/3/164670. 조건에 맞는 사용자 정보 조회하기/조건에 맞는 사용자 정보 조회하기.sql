-- 코드를 입력하세요
SELECT b.user_id user_id, b.nickname nickname,
concat(b.city, " ", b.street_address1, " ", b.street_address2) 전체주소,
concat(substring(tlno, 1, 3), '-',
      substring(tlno, 4, 4), '-',
      substring(tlno, 8, 4)) 전화번호
from used_goods_board a join used_goods_user b on a.writer_id = b.user_id
group by a.writer_id
having count(*) >= 3
order by b.user_id desc
