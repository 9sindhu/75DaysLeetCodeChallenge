# Write your MySQL query statement below
select 
year,price, product_name
from sales
left join product 
on sales.product_id=product.product_id