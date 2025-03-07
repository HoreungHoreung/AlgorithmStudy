-- 코드를 입력하세요
WITH OUTCOME AS (
    SELECT P.PRODUCT_ID, P.PRODUCT_NAME, P.PRICE, O.AMOUNT
    FROM FOOD_PRODUCT P
    JOIN FOOD_ORDER O ON P.PRODUCT_ID = O.PRODUCT_ID
    WHERE O.PRODUCE_DATE LIKE '2022-05%'
)

SELECT PRODUCT_ID, PRODUCT_NAME, SUM(PRICE * AMOUNT) AS TOTAL_AMOUNT
FROM OUTCOME
GROUP BY PRODUCT_ID
ORDER BY TOTAL_AMOUNT DESC, P.PRODUCT_ID;

