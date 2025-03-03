-- 코드를 입력하세요
WITH BOOK_AUTHOR AS (
    SELECT B.BOOK_ID, B.AUTHOR_ID, B.CATEGORY, B.PRICE, A.AUTHOR_NAME
    FROM BOOK B
    JOIN AUTHOR A ON B.AUTHOR_ID = A.AUTHOR_ID)
    
SELECT BA.AUTHOR_ID, BA.AUTHOR_NAME, BA.CATEGORY, SUM((BA.PRICE * S.SALES)) AS TOTAL_SALES
FROM BOOK_AUTHOR BA
JOIN BOOK_SALES S ON BA.BOOK_ID = S.BOOK_ID
WHERE SALES_DATE BETWEEN '2022-01-01' AND '2022-01-31'
GROUP BY BA.AUTHOR_ID, BA.CATEGORY, BA.AUTHOR_NAME
ORDER BY BA.AUTHOR_ID, BA.CATEGORY DESC;

