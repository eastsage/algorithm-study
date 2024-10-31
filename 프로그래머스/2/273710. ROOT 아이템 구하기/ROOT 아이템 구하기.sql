-- 코드를 작성해주세요
select a.item_id, b.item_name
from (select * from item_tree where parent_item_id is null) a
join item_info b on a.item_id = b.item_id