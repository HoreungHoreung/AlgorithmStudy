-- 코드를 입력하세요
SELECT B.category, sum(S.sales) as TOTAL_SALES
FROM BOOK B JOIN BOOK_SALES S on B.book_id = S.book_id
WHERE S.sales_date between '2022-01-01' and '2022-01-31'
GROUP BY B.category
ORDER BY B.category ASC;