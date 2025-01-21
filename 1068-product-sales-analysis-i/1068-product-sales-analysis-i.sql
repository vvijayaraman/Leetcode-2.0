# Write your MySQL query statement below
Select product_name, year, price from sales 
inner join product
on sales.product_id = product.product_id