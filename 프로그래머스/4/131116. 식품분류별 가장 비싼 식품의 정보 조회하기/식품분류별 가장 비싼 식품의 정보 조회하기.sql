-- 코드를 입력하세요
SELECT category, price as MAX_PRICE, product_name
FROM FOOD_PRODUCT
WHERE category in ('식용유', '과자','국','김치') and (category, price) in (select category, max(price) from food_product where category in ('식용유', '과자', '국', '김치') group by category) 
GROUP BY category
ORDER BY MAX_PRICE DESC;

# select * from food_product group by category;