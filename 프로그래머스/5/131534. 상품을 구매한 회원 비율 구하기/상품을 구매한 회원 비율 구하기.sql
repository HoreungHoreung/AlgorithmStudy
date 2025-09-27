-- 코드를 입력하세요
WITH TOTAL AS (
SELECT count(DISTINCT user_id) as TOTAL_USER
FROM USER_INFO
WHERE YEAR(joined) = 2021)

SELECT 
    YEAR(S.sales_date) as YEAR, MONTH(S.sales_date) as MONTH, count(DISTINCT S.user_id) as PURCHASED_USERS, ROUND((count(DISTINCT S.user_id) / T.total_user),1) as PURCHASED_RATIO 
FROM USER_INFO I JOIN ONLINE_SALE S ON I.user_id = S.user_id, TOTAL T
WHERE YEAR(I.joined) = 2021
GROUP BY YEAR(S.sales_date), MONTH(S.sales_date)
ORDER BY 1 ASC, 2 ASC;


    